package com.asynchronous.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asynchronous.dao.UserRespository;
import com.asynchronous.models.User;

@Service
public class UserService {

	@Autowired
	UserRespository userRepo;

	Logger logger = LoggerFactory.getLogger(UserService.class);

	@Async
	public CompletableFuture<List<User>> addUser() {
		List<User> users = Stream.of(new User(1, "punit", "punit@gmail.com"), new User(2, "soni", "soni@gmail.com"))
				.collect(Collectors.toList());
		users = userRepo.saveAll(users);
		return CompletableFuture.completedFuture(users);
	}

	@Async
	public CompletableFuture<List<User>> getUsers() {
		logger.info("get list of users by - " + Thread.currentThread().getName());
		List<User> users = userRepo.findAll();
		List<User> users1 = userRepo.findAll();
		List<User> users2 = userRepo.findAll();
		List<User> users3 = userRepo.findAll();
		List<User> users4 = userRepo.findAll();
		List<User> users5 = userRepo.findAll();
		return CompletableFuture.completedFuture(users);
	}

	public User getUser(@RequestParam int id) {
		return userRepo.findById(id).get();
	}

	public List<User> getAllUsers() {
		logger.info("get list of users by - " + Thread.currentThread().getName());
		List<User> users = userRepo.findAll();
		List<User> users1 = userRepo.findAll();
		List<User> users2 = userRepo.findAll();
		List<User> users3 = userRepo.findAll();
		List<User> users4 = userRepo.findAll();
		List<User> users5 = userRepo.findAll();
		return users;
	}
}
