package com.puneet.userinfo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="user_name")
	private String userName;

	@Column(name="user_password")
	private String userPassword;

	@Column(name="user_phone")
	private String userPhone;

	@Column(name="user_city")
	private String userCity;

	@Column(name="user_address")
	private String userAddress;
	
	
//	public User(int userId, String userName, String userPassword, String userPhone, String userCity,
//			String userAddress) {
//		this.userId = userId;
//		this.userName = userName;
//		this.userPassword = userPassword;
//		this.userPhone = userPhone;
//		this.userCity = userCity;
//		this.userAddress = userAddress;
//	}
//
//	public User() {
//	}
//
//	public int getUserId() {
//		return userId;
//	}
//
//	public void setUserId(int userId) {
//		this.userId = userId;
//	}
//
//	public String getUserName() {
//		return userName;
//	}
//
//	public void setUserName(String userName) {
//		this.userName = userName;
//	}
//
//	public String getUserPassword() {
//		return userPassword;
//	}
//
//	public void setUserPassword(String userPassword) {
//		this.userPassword = userPassword;
//	}
//
//	public String getUserPhone() {
//		return userPhone;
//	}
//
//	public void setUserPhone(String userPhone) {
//		this.userPhone = userPhone;
//	}
//
//	public String getUserCity() {
//		return userCity;
//	}
//
//	public void setUserCity(String userCity) {
//		this.userCity = userCity;
//	}
//
//	public String getUserAddress() {
//		return userAddress;
//	}
//
//	public void setUserAddress(String userAddress) {
//		this.userAddress = userAddress;
//	}
	
	
	
}
