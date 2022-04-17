package com.code.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
//import com.code.dao.UserRowMapper;

import com.code.model.User;

@Repository
public class UserRegistrationDaoImpl implements UserRegistrationDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public int saveUserRegistration(User user) {
		String sql = "INSERT INTO user(fullName, password, email) VALUES('"+ user.getFullName() 
		+ "','" + user.getPassword() + "','" + user.getEmail() + "')";
		
		return jdbcTemplate.update(sql);
	}
	
	public User getUserViaUsername(String email) {
		String sql = "SELECT * FROM springprojdb.user WHERE email = '" + email +"';";
		User user = new User();
		List<User> existingUser = new ArrayList<User>();
		
		existingUser = jdbcTemplate.query(sql, new UserRowMapper());
		
		if (existingUser.size() > 0) {
	        user = existingUser.get(0);
		} else {
			System.out.println("No Existing User");
		}
		
		return user;
	}
	
	@Override
	public User findByEmail(String email) {
		String sql = "SELECT * FROM springprojdb.user WHERE email='" + email +"';";
//		return jdbcTemplate.query(sql, new ResultSetExtractor<User>() {
//			@Override
//			public User extractData(ResultSet rs) throws SQLException, DataAccessException {
//				if (rs.next()) {
//					User user = new User();
//					user.setEmail(rs.getString("email"));
//					user.setFullName(rs.getString("fullname"));
//					user.setPassword(rs.getString("password"));
//					return user;
//				}
//				return null;
//			}
//		});
		
		return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(User.class));
	}
	
	@Override
	public List<User> listOfUsers() {
		String sql = "SELECT * FROM user";
		List<User> listOfUsers = jdbcTemplate.query(sql, new RowMapper<User>() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				User user = new User();
				user.setUserId(rs.getInt("userId"));
				user.setEmail(rs.getString("email"));
				user.setFullName(rs.getString("fullname"));
				System.out.println(user.getUserId());
				return user;
			}
		});
		
		return listOfUsers;
	}	
}
