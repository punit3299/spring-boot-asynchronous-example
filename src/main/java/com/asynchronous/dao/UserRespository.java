package com.asynchronous.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.asynchronous.models.User;

public interface UserRespository extends JpaRepository<User, Integer> {

}
