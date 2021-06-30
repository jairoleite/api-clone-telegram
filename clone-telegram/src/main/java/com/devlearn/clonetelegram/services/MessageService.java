package com.devlearn.clonetelegram.services;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlearn.clonetelegram.dtos.MessageDTO;
import com.devlearn.clonetelegram.entities.Message;
import com.devlearn.clonetelegram.repositories.MessageRepository;

@Service
public class MessageService {

	@Autowired
	private MessageRepository messageRepository;
	
	@Transactional
	public void saveMessage(MessageDTO dto) {
		Message message = new Message(dto.getText(), Instant.now(), dto.getUserUuid(), dto.getUserSendUuid());
		messageRepository.save(message);
	}
}
