package com.revature.controllers;

import java.net.URI;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.revature.models.User;
import com.revature.repos.UserRepo;
import com.revature.security.JwtTokenProvider;
import com.revature.security.payloads.ApiResponse;
import com.revature.security.payloads.JwtAuthenticationResponse;
import com.revature.security.payloads.LoginRequest;
import com.revature.security.payloads.SignupRequest;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtTokenProvider tokenProvider;
	
	@PostMapping("/login")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsernameOrEmail(),
						loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// adding code below to load the user and return user info with the token in the response
		String usernameOrEmail = loginRequest.getUsernameOrEmail();
		Optional<User> user = userRepo.getUserByUsernameOrEmail(usernameOrEmail, usernameOrEmail);
		
		String jwt = tokenProvider.generateToken(authentication);
		return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, user));
	}
	
	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signupRequest) {
		if(userRepo.existsByUsername(signupRequest.getUsername())) {
			return new ResponseEntity(new ApiResponse(false, "username is already taken"),
					HttpStatus.BAD_REQUEST);
		}
		
		if(userRepo.existsByEmail(signupRequest.getEmail())) {
			return new ResponseEntity(new ApiResponse(false, "this email already in use"),
					HttpStatus.BAD_REQUEST);
		}
		
		// Creating user's account
		User user = new User(signupRequest.getFirstName(), signupRequest.getLastName(), signupRequest.getUsername(),
				signupRequest.getPassword(), signupRequest.getEmail(), signupRequest.getRole(),
				signupRequest.getCategory());
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		User result = userRepo.save(user);
		
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath().path("/api/users/{username}")
				.buildAndExpand(result.getUsername()).toUri();
		
		return ResponseEntity.created(location).body(new ApiResponse(true, "user registered successfully"));
	}
}
