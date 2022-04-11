<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Login</title>
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
		
		<form action="/validate" method="post">
			Email: <input type="text" class="form-control" id="email" name="email"/> <br/>
			Password: <input type="password" class="form-control" id="password" name="password"/> <br/>
			<button class='btn btn-primary' type="submit">Login</button>
		</form>
	</div>
	<script src="js/myScript.js"></script>
</body>
</html>