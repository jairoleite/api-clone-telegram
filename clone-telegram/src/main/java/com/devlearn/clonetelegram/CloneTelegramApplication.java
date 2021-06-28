package com.devlearn.clonetelegram;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.devlearn.clonetelegram.socket.model.User;

@SpringBootApplication
public class CloneTelegramApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloneTelegramApplication.class, args);
	}
	
	@Bean(name = "mapUsers")
	public Map<String, User> mapUsers() {
		HashMap<String, User> users = new HashMap<>();
		return users;
	}
}
