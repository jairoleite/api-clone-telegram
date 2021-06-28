package com.devlearn.clonetelegram.socket;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOServer;

@Service
public class SocketIoServer {
	
	private SocketIOServer server;
	
	@Autowired
	private Events events;

	@PostConstruct
	private void autoStartup() throws Exception {
		start();
	}

	@PreDestroy
	private void autoStop() throws Exception  {
		stop();
	}

	public void start() {
		Configuration config = new Configuration();
		config.setHostname("127.0.0.1");
		config.setPort(9000);

		server = new SocketIOServer(config);
		events.makeEvents(server);
		server.start();
	}

	public void stop() {
		if (server != null) {
			server.stop();
			server = null;
		}
	}
}
