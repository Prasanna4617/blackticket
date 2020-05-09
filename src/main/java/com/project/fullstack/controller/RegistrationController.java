package com.project.fullstack.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.project.fullstack.entity.UserEntity;
import com.project.fullstack.exception.EmailIdAlreadyPresentException;
import com.project.fullstack.model.LoginCredential;
import com.project.fullstack.model.User;
import com.project.fullstack.service.RegistrationService;
import com.project.fullstack.service.AuthenticationService;


@RestController
public class RegistrationController {
	
	@Autowired
	private RegistrationService registrationService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/register")
	public String register() {
		return "Success";
	}
	
	@PostMapping("/registerUser")
	public void registerUser(@RequestBody User user) {
		try {
			registrationService.registerUser(user);
		} catch (EmailIdAlreadyPresentException e) {

			System.out.println(e);
			}
		}
	
	@PostMapping("/authenticateUser")
	public String authenticateUser(@RequestBody LoginCredential details) {
		try{
			
			String authenticate = authenticationService.authenticateUser(details);
			if(authenticate != null) {
				return authenticate;
			}else {
				return null;
			}
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	}
	
	

