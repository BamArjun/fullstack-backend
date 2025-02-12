package com.snsc.spring_fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.snsc.spring_fullstack.model.User;
import com.snsc.spring_fullstack.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@CrossOrigin("http://localhost:3000/")
public class UserController {
	@Autowired
	private UserRepository userrepo;
	
	@PostMapping("/user")
	User newUser(@RequestBody User newUser) {
		//TODO: process POST request
		
		return userrepo.save(newUser);
	}
	@GetMapping("/userdata")
	List<User> getAllUser()  {
		return userrepo.findAll();
	
	}
	
	
	
	
	

}
