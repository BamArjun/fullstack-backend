package com.snsc.spring_fullstack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.snsc.spring_fullstack.exception.UserNotFoundException;
import com.snsc.spring_fullstack.model.User;
import com.snsc.spring_fullstack.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;


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
	
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable Long id) {
		return userrepo.findById(id)
		.orElseThrow(()-> new UserNotFoundException(id));
		
	}
	
	@PutMapping("user/{id}")
	public User  updateUser(@PathVariable Long id, @RequestBody User newUser ) {
		//TODO: process PUT request
		
		return  userrepo.findById(id)
				.map(user->{
					user.setUsername(newUser.getUsername());
					user.setName(newUser.getName());
					user.setEmail(newUser.getEmail());
					return userrepo.save(user);
				}).orElseThrow(()->new UserNotFoundException(id));
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable Long id) {
		if(!userrepo.existsById(id)){
			throw new UserNotFoundException(id);
		}
		userrepo.deleteById(id);
		return "user with id "+id+" is deleted sucessfully";
		
	}
	
	
	

}
