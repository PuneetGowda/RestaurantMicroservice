package com.puneet.userinfo.utilities;

import org.springframework.stereotype.Component;

import com.puneet.userinfo.dto.UserDTO;
import com.puneet.userinfo.entity.User;

@Component
public class UserMapper {

	public User mapUserDTOToUser(UserDTO userDTO) {
		return new User(userDTO.getUserId(), userDTO.getUserName(), userDTO.getUserPassword(), userDTO.getUserPhone(), userDTO.getUserCity(), userDTO.getUserAddress());
	}
	
	public UserDTO mapUserToUserDTO(User user) {
		return new UserDTO(user.getUserId(), user.getUserName(), user.getUserPassword(), user.getUserPhone(), user.getUserCity(), user.getUserAddress());
	}
}
