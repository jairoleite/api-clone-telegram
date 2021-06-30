package com.devlearn.clonetelegram.entities;

import java.time.Instant;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tb_message")
@Getter @Setter @NoArgsConstructor
public class Message {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String text;
	private Boolean view;
	private Instant registryDate;
	private String userUuid;
	private String userSendUuid;
	
	public Message(String text, Instant registryDate, String userUuid, String userSendUuid) {
		this.text = text;
		this.registryDate = registryDate;
		this.userUuid = userUuid;
		this.userSendUuid = userSendUuid;
	}
	
	
}
