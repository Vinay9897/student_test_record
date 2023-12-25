package com.authentication.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	Optional<User> findByEmail(String username);

	void save(com.authentication.entities.User user);

}
