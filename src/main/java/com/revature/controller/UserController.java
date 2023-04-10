package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.exception.UserException;
import com.revature.model.User;
import com.revature.service.UserService;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
public class UserController {
	private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(UserController.class);

	@Autowired
	private UserService userService;
	
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.findAllUsers();
	}
	
	@GetMapping("/user/{username}")
	public User getUserByUsername(@PathVariable String username) {
		return userService.findUserByUsername(username);
	}
	
//	@GetMapping("/portnumber")
//	public String getPortNumber() {
//		return "portnumber" + server.port;
//	}
	
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		log.info("User created successfully!");
		return userService.createUser(user);
	}
	
	
	@PutMapping("/updateUser/{userId}")
	public User updateUser(@PathVariable int userId, @RequestBody User user) throws UserException {
		return userService.updateUser(userId,user);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public String deleteUser(@PathVariable int userId) {
		return userService.deleteUser(userId);
	}

}
