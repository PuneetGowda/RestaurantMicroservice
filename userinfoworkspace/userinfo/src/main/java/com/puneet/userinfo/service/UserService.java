package com.puneet.userinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.puneet.userinfo.dao.UserDAO;
import com.puneet.userinfo.dto.UserDTO;
import com.puneet.userinfo.entity.User;
import com.puneet.userinfo.utilities.UserMapper;

@Service
public class UserService {

	@Autowired
	UserDAO userDAO;
	
	@Autowired
	UserMapper userMapper;

	public UserDTO addUser(UserDTO userDTO) {
		User savedUser = userDAO.save(userMapper.mapUserDTOToUser(userDTO));
		return userMapper.mapUserToUserDTO(savedUser);
	}

	public ResponseEntity<UserDTO> fetchUserDetailsById(Integer userId) {
		Optional<User> user = userDAO.findById(userId);
		if (user.isPresent())
			return new ResponseEntity<>(userMapper.mapUserToUserDTO(user.get()), HttpStatus.OK);
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
}
