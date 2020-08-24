package com.revature.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Category;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.CategoryRepo;
import com.revature.repos.RoleRepo;
import com.revature.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RoleRepo roleRepo;
	
	@Autowired
	private CategoryRepo catRepo;
	
	
	public List<User> getAllUsers() {
		return userRepo.findAll();
	}
	
	public User saveOrUpdateUser(User user) {
		return userRepo.save(user);
	}
	
	public Optional<List<User>> getUsersByRole(String role) {
		Optional<Role> newRole = roleRepo.getRoleByRole(role);
		return userRepo.getUsersByRole(newRole);
	}
	
	public Optional<List<User>> getUsersByCategory(String category) {
		Optional<Category> newCat = catRepo.getCategoryByCategory(category);
		return userRepo.getUsersByCategory(newCat);
	}
	
	public Optional<List<User>> getUsersByRoleAndCategory(String role, String category) {
		Optional<Role> newRole = roleRepo.getRoleByRole(role);
		Optional<Category> newCat = catRepo.getCategoryByCategory(category);
		return userRepo.getUsersByRoleAndCategory(newRole, newCat);
	}
}
