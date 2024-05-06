package com.puneet.userinfo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.puneet.userinfo.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer> {

}
