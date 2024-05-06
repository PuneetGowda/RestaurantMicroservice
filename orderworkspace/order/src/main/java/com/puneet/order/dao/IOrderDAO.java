package com.puneet.order.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.puneet.order.entity.Order;

@Repository
public interface IOrderDAO extends MongoRepository<Order, Integer> {

}
