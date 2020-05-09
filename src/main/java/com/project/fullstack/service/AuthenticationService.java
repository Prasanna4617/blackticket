package com.project.fullstack.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fullstack.entity.UserEntity;
import com.project.fullstack.model.LoginCredential;
import com.project.fullstack.model.User;
import com.project.fullstack.repository.UserRepository;

@Service
public class AuthenticationService {
	
	@Autowired
	private UserRepository userRepository;
	private String email;
	private String password;
	private String userName;
	private UserEntity loginInstance;
	
	public List<UserEntity> getAllUser(){
		return userRepository.findAll();
	}

	public String authenticateUser(LoginCredential details){
		email = details.getEmail();
		password = details.getPassword();
		if(userRepository.existsById(email)) {
			loginInstance = userRepository.getOne(email);
			if(password.equals(loginInstance.getPassword())) {
				return userName;
			}else {
				return null;
			}
		}else {
			return null;
		}
	}
}
