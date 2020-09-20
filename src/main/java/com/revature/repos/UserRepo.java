package com.revature.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.Category;
import com.revature.models.Role;
import com.revature.models.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	Optional<List<User>> getUsersByRole(Optional<Role> role);
	
	Optional<List<User>> getUsersByCategory(Optional<Category> category);
	
	Optional<List<User>> getUsersByRoleAndCategory(Optional<Role> role, Optional<Category> category);
	
	Optional<User> getUserByUsernameOrEmail(String username, String email);
	
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
}
