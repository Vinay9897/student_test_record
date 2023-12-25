package com.authentication.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.authentication.entities.User;
import com.authentication.repo.UserRepository;

@Service
public class AuthService {
	
	
	@Autowired
	private JwtService iml;
	
	@Autowired
    private PasswordEncoder passwordEncoder; 
	
	@Autowired
	private UserRepository userRepository;
	
	
	 public String saveUser(User user) {
		 	user.setFirstName(user.getFirstName());
		 	user.setSecondName(user.getSecondName());
		 	user.setEmail(user.getEmail());
//		 	user.setRole(user.getRole());
	        user.setPassword(passwordEncoder.encode(user.getPassword()));
	       userRepository.save(user);
	        return "user added to the system";
	    }

	 public String generateToken(String username) {
			
			return iml.generateToken(username);
		}
}
