package com.project.fullstack.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.fullstack.entity.UserEntity;
import com.project.fullstack.exception.EmailIdAlreadyPresentException;
import com.project.fullstack.model.User;
import com.project.fullstack.repository.UserRepository;

@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	public void registerUser(User user) throws EmailIdAlreadyPresentException{
		boolean ue = userRepository.existsById(user.getEmail());
		if (ue)
			throw new EmailIdAlreadyPresentException("RegistrationService.EMAILID_PRESENT");
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail(user.getEmail());
		userEntity.setFname(user.getFname());
		userEntity.setLname(user.getLname());
		userEntity.setPassword(user.getPassword());
		userEntity.setPhone(user.getPhone());
		
		userRepository.saveAndFlush(userEntity);
		
		
	}
	

}
