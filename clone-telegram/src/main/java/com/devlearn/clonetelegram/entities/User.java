package com.devlearn.clonetelegram.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_user")
@Getter @Setter @NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String uuid;
	private String name;
	private String image;
	private Boolean online;
	
	public User(String uuid, String name, String image, Boolean online) {
		this.uuid = uuid;
		this.name = name;
		this.image = image;
		this.online = online;
	}
	
}
