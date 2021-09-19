package com.asynchronous.controllers;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.asynchronous.dao.UserRespository;
import com.asynchronous.models.User;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	UserRespository userRepo;

	@PostMapping
	public void addUser() {
		List<User> list = Stream.of(new User(1, "punit", "punit@gmail.com"), new User(2, "soni", "soni@gmail.com"))
				.collect(Collectors.toList());
		userRepo.saveAll(list);
	}

	@GetMapping
	public List<User> getUsers() {
		return userRepo.findAll();
	}

	@GetMapping("/user")
	public User getUser(@RequestParam int id) {
		return userRepo.findById(id).get();
	}

}
