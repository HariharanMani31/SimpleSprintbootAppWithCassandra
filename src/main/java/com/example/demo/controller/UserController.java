package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.*;
import com.example.demo.repository.*;

@RestController
public class UserController {

	@Autowired
	private UserRepository repository;

	@PostConstruct
	public void saveUser() {
		List<UserModel> users = new ArrayList<>();
		users.add(new UserModel(6437, "Basant", "Bangalore", 50));
		users.add(new UserModel(3523, "Saroj", "Pune", 20));
		users.add(new UserModel(8694, "Ravindra", "Mumbai", 30));
		users.add(new UserModel(9854, "Samas", "Odisha", 25));
		repository.saveAll(users);
	}

	@GetMapping("/getAllUsers")
	public List<UserModel> getUsers() {
		return repository.findAll();
	}

	@GetMapping("/getUserFilterByAge/{age}")
	public List<UserModel> getUserFilterByAge(@PathVariable int age) {
		return repository.findByAgeGreaterThan(age);
	}
}
