package com.puneet.foodcatalogue.entity;

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
public class FoodItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_description")
	private String itemDescription;
	
	@Column(name="is_veg")
	private boolean isVeg;
	
	@Column(name="item_price")
	private Number itemPrice;
	
	@Column(name="restaurant_id")
	private Integer restaurantId;
	
	@Column(name = "item_quantity", nullable = false, columnDefinition = "INT DEFAULT 0")
	private Integer itemQuantity;
}
