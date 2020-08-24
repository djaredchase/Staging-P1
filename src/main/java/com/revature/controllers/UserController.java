package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;


@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/role/{roleName}")
	public Optional<List<User>> getUsersByRole(@PathVariable String roleName) {
		return userService.getUsersByRole(roleName);
	}
	
	@GetMapping("/category/{catName}")
	public Optional<List<User>> getUsersByCategory(@PathVariable String catName) {
		return userService.getUsersByCategory(catName);
	}
	
	@GetMapping("/filter/{roleName}/{catName}")
	public Optional<List<User>> getUsersByRoleAndCategory(@PathVariable String roleName, @PathVariable String catName) {
		return userService.getUsersByRoleAndCategory(roleName, catName);
	}
	
	@PostMapping
	public User saveUser(@RequestBody User user) {
		return userService.saveOrUpdateUser(user);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userService.saveOrUpdateUser(user);
	}
}
