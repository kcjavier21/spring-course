package com.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.code.model.User;

public class UserRowMapper implements RowMapper<User> {
	
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setFullName(rs.getString("fullName"));
		user.setEmail(rs.getString("email"));
		
		System.out.println(user.getFullName());
		return user;
	}
}
