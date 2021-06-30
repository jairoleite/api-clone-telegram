package com.devlearn.clonetelegram.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.devlearn.clonetelegram.dtos.UserDTO;
import com.devlearn.clonetelegram.services.UserService;

@RestController
@RequestMapping("users")
public class UserResource {

	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public ResponseEntity<List<UserDTO>> listAll(@RequestParam(value = "name") String name) {
		return ResponseEntity.ok(userService.listAll(name));
	}
	
	@GetMapping("/byname")
	public ResponseEntity<UserDTO> getByName(@RequestParam(value = "name") String name) {
		return ResponseEntity.ok(userService.getUserByName(name));
	}
}

