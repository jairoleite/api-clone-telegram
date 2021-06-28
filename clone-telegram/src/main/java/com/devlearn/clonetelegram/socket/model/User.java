package com.devlearn.clonetelegram.socket.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class User {

	private String uuid;
	private String name;
	private String image;
	private Boolean online;
	
	public User() {
	}

	public User(String uuid, String name, String image, Boolean online) {
		this.uuid = uuid;
		this.name = name;
		this.image = image;
		this.online = online;
	}

	@Override
	public String toString() {
		return "User [uuid=" + uuid + ", name=" + name + ", image=" + image + ", online=" + online + "]";
	}

}
