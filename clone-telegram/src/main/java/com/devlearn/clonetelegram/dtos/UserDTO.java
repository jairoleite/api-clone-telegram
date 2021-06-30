package com.devlearn.clonetelegram.dtos;

import com.devlearn.clonetelegram.entities.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class UserDTO {

	private Long id;
	private String uuid;
	private String name;
	private String image;
	private Boolean online;
	
	public UserDTO(User entity) {
		this.id = entity.getId();
		this.uuid = entity.getUuid();
		this.name = entity.getName();
		this.image = entity.getImage();
		this.online = entity.getOnline();
	}
	
}
