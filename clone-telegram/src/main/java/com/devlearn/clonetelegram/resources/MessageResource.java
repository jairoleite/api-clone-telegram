package com.devlearn.clonetelegram.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlearn.clonetelegram.repositories.MessageRepository;
import com.devlearn.clonetelegram.repositories.interfaces.MessageInterface;

@RestController
@RequestMapping("messages")
public class MessageResource {

	@Autowired
	private MessageRepository messageRepository;
	
	@GetMapping("/{uuid}/{userSendUuid}")
	public ResponseEntity<List<MessageInterface>> listByUserUuid(@PathVariable String uuid, @PathVariable String userSendUuid) {
		return ResponseEntity.ok(messageRepository.listByUserUuid(uuid));
	}
}
