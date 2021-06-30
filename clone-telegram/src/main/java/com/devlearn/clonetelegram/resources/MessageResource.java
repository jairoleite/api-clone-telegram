package com.devlearn.clonetelegram.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devlearn.clonetelegram.dtos.MessageDTO;
import com.devlearn.clonetelegram.services.MessageService;

@RestController
@RequestMapping("messages")
public class MessageResource {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/{uuid}")
	public ResponseEntity<List<MessageDTO>> listByUserUuid(@PathVariable String uuid) {
		return ResponseEntity.ok(messageService.listMessage(uuid));
	}
}
