package com.devlearn.clonetelegram.socket.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Chat {

	private String uuid;
	private String message;
	
	public Chat() {}
	
	public Chat(String message) {
		this.message = message;
	}
	
	public Chat(String uuid, String message) {
		this.setUuid(uuid);
		this.setMessage(message);
	}
	
	
	
}