package com.devlearn.clonetelegram.dtos;

import java.time.Instant;

import com.devlearn.clonetelegram.entities.Message;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MessageDTO {

	private Long id;
	private String text;
	private Boolean view;
	private Instant registryDate;
	private String userUuid;
	private String userSendUuid;
	
	public MessageDTO() {
	}

	public MessageDTO(Message entity) {
		this.id = entity.getId();
		this.text = entity.getText();
		this.view = entity.getView();
		this.registryDate = entity.getRegistryDate();
		this.userUuid = entity.getUserUuid();
		this.userSendUuid = entity.getUserUuid();
	}

	@Override
	public String toString() {
		return "MessageDTO [id=" + id + ", text=" + text + ", userUuid=" + userUuid + "]";
	}
	
}
