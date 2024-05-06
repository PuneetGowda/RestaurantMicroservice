package com.puneet.restaurant.entity;

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
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="restaurant_id")
	private int restaurantId;
	
	@Column(name="restaurant_name")
	private String restaurantName;
	
	@Column(name="restaurant_address")
	private String restaurantAddress;
	
	@Column(name="restaurant_city")
	private String restaurantCity;
	
	@Column(name="restaurant_description")
	private String restaurantDescription;

//	public int getRestaurantId() {
//		return restaurantId;
//	}
//
//	public void setRestaurantId(int restaurantId) {
//		this.restaurantId = restaurantId;
//	}
//
//	public String getRestaurantName() {
//		return restaurantName;
//	}
//
//	public void setRestaurantName(String restaurantName) {
//		this.restaurantName = restaurantName;
//	}
//
//	public String getRestaurantAddress() {
//		return restaurantAddress;
//	}
//
//	public void setRestaurantAddress(String restaurantAddress) {
//		this.restaurantAddress = restaurantAddress;
//	}
//
//	public String getRestaurantCity() {
//		return restaurantCity;
//	}
//
//	public void setRestaurantCity(String restaurantCity) {
//		this.restaurantCity = restaurantCity;
//	}
//
//	public String getRestaurantDescription() {
//		return restaurantDescription;
//	}
//
//	public void setRestaurantDescription(String restaurantDescription) {
//		this.restaurantDescription = restaurantDescription;
//	}
//
//	@Override
//	public String toString() {
//		return "Restaurant [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName
//				+ ", restaurantAddress=" + restaurantAddress + ", restaurantCity=" + restaurantCity
//				+ ", restaurantDescription=" + restaurantDescription + "]";
//	}
//	
	
}
