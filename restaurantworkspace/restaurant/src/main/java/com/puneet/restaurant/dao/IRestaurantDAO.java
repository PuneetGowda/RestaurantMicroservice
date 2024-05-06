package com.puneet.restaurant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puneet.restaurant.entity.Restaurant;

@Repository
public interface IRestaurantDAO extends JpaRepository<Restaurant, Integer> {

}
