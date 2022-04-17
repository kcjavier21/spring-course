package com.code.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.code.model.User;
@Component
public interface UserRegistrationDao {
	public int saveUserRegistration(User user);
	public User getUserViaUsername(String username);
	public User findByEmail(String email);
	public List<User> listOfUsers();
}
