package com.devlearn.clonetelegram.socket;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.devlearn.clonetelegram.socket.model.Chat;
import com.devlearn.clonetelegram.socket.model.User;

@Service
public class Events {
	
	@Qualifier("mapUsers")
	@Autowired
	private Map<String, User> mapUsers;
	
		
	public void makeEvents(SocketIOServer server) {
		
		server.addEventListener(EnumEvents.CONNECT.toString(), User.class, (client, data, ackRequest) -> {
			
			System.out.println("connectou...");
			
			User user = mapUsers.get(data.getUuid());
			if(user == null) {
				user = new User(data.getUuid(), data.getName(), data.getImage(), data.getOnline());
				
				mapUsers.put(data.getUuid(), user);
				System.out.println(user.toString());
				
				System.out.println("usuário adiciona...");
			}
			else {
				user.setOnline(true);
				mapUsers.put(data.getUuid(), user);
				System.out.println("usuário atualizado...");
			}
			
			
			//atualiza todos os usuários com listagem novas
			JSONArray array = new JSONArray();
			for (Entry<String, User> mapKey: mapUsers.entrySet()) {
				array.add(mapKey.getValue()); 
			} 
			
			server.getBroadcastOperations().sendEvent(EnumEvents.USER_LIST.toString(), array);
			
		});	
		
		/**
		 * Evento quando o usuário desconectar
		 */
		server.addDisconnectListener(client -> {
            String uid = getParamsByClient(client);
            User user = mapUsers.get(uid);
            if (uid != null) {
            	client.disconnect();
            	
            	user.setOnline(false);
            	mapUsers.put(user.getUuid(), user);
            	
            	JSONArray array = new JSONArray();
            	for (Entry<String, User> mapKey: mapUsers.entrySet()) {
            		array.add(mapKey.getValue()); 
            	} 
            	
            	server.getBroadcastOperations().sendEvent(EnumEvents.USER_LIST.toString(), array);
            }
            
        });
		
		server.addEventListener(EnumEvents.SEND_MESSAGE.toString(), Chat.class, (client, data, ackRequest) -> {
			server.getBroadcastOperations().sendEvent(EnumEvents.SEND_MESSAGE.toString(), data);
		});	
	
		server.addEventListener(EnumEvents.SEND_MESSAGE.toString(), Chat.class, (client, data, ackRequest) -> {
			server.getBroadcastOperations().sendEvent(EnumEvents.SEND_MESSAGE.toString(), data);
		});		
		
	}
	
	private String getParamsByClient(SocketIOClient client) {
        // Take the argument from the requested connection (the sid here must be a unique identifier)
        Map<String, List<String>> params = client.getHandshakeData().getUrlParams();
        List<String> list = params.get("UID");
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
	
	
}