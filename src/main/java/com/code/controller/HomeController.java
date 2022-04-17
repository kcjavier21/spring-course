package com.code.controller;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.code.dao.UserRegistrationDao;
import com.code.model.User;
import org.springframework.web.bind.annotation.RequestParam;

// import java.lang.Thread;

@Controller
public class HomeController {
	@Autowired
	private User user;
	
	@Autowired
	private UserRegistrationDao userRegistrationDao;
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/register")
	public String signupPage() {
		return "register";
	}
	
	@RequestMapping("/validate")
	public String validateEmailAddress(Model model, 
			@RequestParam("email") String email, 
			@RequestParam("password") String password) 
	{
		user = userRegistrationDao.findByEmail(email);
		
		System.out.println(email);
		System.out.println(password);
		
		if (user == null) {
			model.addAttribute("error", "Invalid email or password");
			return "login";
		}
		
		if (!(email.equals(user.getEmail()) && password.equals(user.getPassword()))) {
			model.addAttribute("error", "Invalid email or password");
			return "login";
		}
		
		System.out.println(user.getEmail());
		System.out.println(user.getFullName());
		System.out.println(user.getPassword());
		return "index";
	}
	
	
	@RequestMapping(value="/validate-signup", method=RequestMethod.GET)
	public String signup(Model model,
			@RequestParam("fullName") String fullName,
			@RequestParam("password") String password,
			@RequestParam("confirmPassword") String confirmPassword,
			@RequestParam("email") String email
	) {
		User existingUser = userRegistrationDao.getUserViaUsername(email);
		
		System.out.println((fullName == "" || password == "" || email == ""));
		
		if (fullName == "" || password == "" || email == "") {
			model.addAttribute("error", "Please fill all the fields!");
			return "register";
		} else if (existingUser.getEmail() != null) {
			model.addAttribute("error", "Email has already been used!");
			return "register";
		} else if (!(password.equals(confirmPassword))) {
			model.addAttribute("error", "Passwords do not match!");
			return "register";
		} else {
			System.out.println("Good!");
		}

		user.setFullName(fullName);
		user.setPassword(password);
		user.setEmail(email);
		
		int result = userRegistrationDao.saveUserRegistration(user);
		
		if (result > 0) {
			System.out.println("Successfully saved data");
		}
		
		// Successful
		model.addAttribute("fullName", " " + fullName);
		return "index";
	}
	
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public String listOfUserPage(Model model) {
		List<User> listOfUsers = userRegistrationDao.listOfUsers();
		
//		for (User user : listOfUsers) {
//			System.out.println(user.getFullName() + " " + user.getEmail());
//		}
		model.addAttribute("listOfUsers", listOfUsers);
		return "list";
	}
}



