package com.asynchronous.controllers;

import java.util.List;
import java.util.concurrent.CompletableFuture;
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
import com.asynchronous.services.UserService;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public CompletableFuture<List<User>> addUser() {
		 return userService.addUser();
	}

	@GetMapping
	public CompletableFuture<List<User>> getUsers() {
		return userService.getUsers();
	}

	@GetMapping("/user")
	public User getUser(@RequestParam int id) {
		return userService.getUser(id);
	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
}
