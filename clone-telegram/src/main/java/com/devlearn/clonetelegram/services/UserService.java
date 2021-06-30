package com.devlearn.clonetelegram.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devlearn.clonetelegram.dtos.UserDTO;
import com.devlearn.clonetelegram.entities.User;
import com.devlearn.clonetelegram.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<UserDTO> listAll() {
		return userRepository.findAll().stream().map(u -> new UserDTO(u)).collect(Collectors.toList());
	}
	
	@Transactional(readOnly = true)
	public UserDTO getUserByName(String name) {
		User user = userRepository.findByName(name);
		
		if(user == null) {
			return null;
		}
		
		return new UserDTO(user);
	}

	@Transactional
	public User saveUser(String uuid, String name, String image, Boolean online) {
		
		User user = userRepository.getByUuid(uuid);
		if(user == null) {
			user = new User(uuid, name, image, online);
		}
		
		user.setOnline(online);
		user = userRepository.save(user);
		return user;
	}
	
	@Transactional
	public void verifyOnline(String uuid, Boolean online) {
		User user = userRepository.getByUuid(uuid);
		user.setOnline(online);
		userRepository.save(user);
	}
}
