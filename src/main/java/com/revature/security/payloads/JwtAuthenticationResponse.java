package com.revature.security.payloads;

import java.util.Optional;

import com.revature.models.User;

public class JwtAuthenticationResponse {

	private String accessToken;
	
	private String tokenType = "Bearer";
	
	//added user instance variable and included in constructor to include in login response
	private Optional<User> user;

	public JwtAuthenticationResponse(String accessToken, Optional<User> user) {
		super();
		this.accessToken = accessToken;
		this.user = user;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Optional<User> getUser() {
		return user;
	}

	public void setUser(Optional<User> user) {
		this.user = user;
	}
}
