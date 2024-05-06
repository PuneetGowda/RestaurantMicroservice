package com.puneet.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

	private int userId;	
	private String userName;
	private String userPassword;
	private String userPhone;
	private String userCity;
	private String userAddress;
}