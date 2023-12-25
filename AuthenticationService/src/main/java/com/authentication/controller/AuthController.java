package com.authentication.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.authentication.entities.AuthRequest;
import com.authentication.entities.User;
import com.authentication.service.AuthService;
import com.authentication.service.JwtService;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	UserDetails userDetails;

	@Autowired
	private AuthService service;

	@Autowired
	private JwtService jwtService;

	@PostMapping(value = "/register")
	public String addNewUser(@RequestBody User user) {
		return service.saveUser(user);
	}

	@GetMapping(value = "/token")
	public String getToken(@RequestBody AuthRequest authRequest) {
		Authentication authenticate = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword()));
		if (authenticate.isAuthenticated()) {
			return service.generateToken(authRequest.getUsername());
		} else {
			throw new RuntimeException("invalid access");
		}
	}

	@GetMapping("/validate")
	public String validateToken(@RequestParam("token") String token, UserDetails userDetails) {
		jwtService.isTokenValid(token, userDetails);
		return "Token is valid";
	}
}
