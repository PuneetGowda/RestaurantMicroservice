package com.puneet.userinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.puneet.userinfo.dto.UserDTO;
import com.puneet.userinfo.service.UserService;

@RestController
@RequestMapping("/usersapi/v1")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<UserDTO> fetchUserDetailsById(@PathVariable Integer user_id) {
		return userService.fetchUserDetailsById(user_id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserDTO> addUser(@RequestBody UserDTO userDTO) {
		UserDTO savedUser = userService.addUser(userDTO);
		return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
	}
	
}