package com.microservico.hroauth.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservico.hroauth.entities.User;
import com.microservico.hroauth.feignclients.UserFeignClient;

@Service
public class UserService {

	private static Logger logger = LoggerFactory.getLogger(UserService.class);
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	public User findByEmail(String email) {
		 User user = userFeignClient.findByEmail(email).getBody(); //A resposta de linha é um Response Entity de usuario, para eu pegar um usuario que ta dentro do response entity eu tenho que dar um ponto .getBodt();
		 if (user == null) {
			 logger.error("Email not found: " + email);
			 throw new IllegalArgumentException("Email not found");
		 }
		 logger.info("Email found: " + email);
		 return user;
	}
}
