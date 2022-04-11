<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Sign Up</title>
</head>
<body>
	<div class="container" style="margin-top: 7vh; width: 400px; max-width: 90%;">
		<% 
			String error = String.valueOf(request.getAttribute("error"));
			 
			if (error.equals("null")) {
				error = "";
			} else {
				error = "<div class='alert alert-danger' role='alert'>" + error + "</div>";
			}
		%>
		<%= error %>
		<form action="/validate-signup" onsubmit="signup()" method="post">
			Email:
			<input type="email" class="form-control" id="email" name="email"/>
			<br/>
			Full Name:
			<input type="text" class="form-control" id="fullName" name="fullName"/>
			<br/>
			Password:
			<input type="password" class="form-control" id="password" name="password"/>
			<br/>
			Confirm Password:
			<input type="password" class="form-control" id="confirmPassword" name="confirmPassword"/>
			<br/>
			
			<button class='btn btn-primary' type="submit">Register</button>
		</form>
	</div>
	<script src="js/myScript.js"></script>
</body>
</html>