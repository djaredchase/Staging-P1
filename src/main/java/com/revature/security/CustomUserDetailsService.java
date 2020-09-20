package com.revature.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.User;
import com.revature.repos.UserRepo;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepo userRepo;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
		User user = userRepo.getUserByUsernameOrEmail(usernameOrEmail, usernameOrEmail)
				.orElseThrow(() ->
						new UsernameNotFoundException("User not found with username or email: " + usernameOrEmail));
		
		return UserPrincipal.create(user);
	}
	
	// This method is used by JwtAuthenticationFilter
	@Transactional
	public UserDetails loadUserById(Integer id) {
		User user = userRepo.findById(id).orElseThrow(
				() -> new UsernameNotFoundException("User not found with id: " + id));
		
		return UserPrincipal.create(user);
	}
}
