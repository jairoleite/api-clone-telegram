package com.devlearn.clonetelegram.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
	
	public List<MessageDTO> listMessage(String uuid) {
		return messageRepository.listByUserUuid(uuid).stream().map(m -> new MessageDTO(m)).collect(Collectors.toList());
	}
	
	@Transactional
	public void saveMessage(Message message) {
		message.setRegistryDate(LocalDateTime.now());
		messageRepository.save(message);
	}
}
