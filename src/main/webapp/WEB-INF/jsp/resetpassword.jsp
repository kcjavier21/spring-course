<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>Reset Password</title>
</head>
<body>
	<div class="container">
		<form action="/resetpassword" method="post">
			Email: <input type="text" class="form-control" id="recipient" name="recipient"/> <br/>
			<button class='btn btn-primary' type="submit">Send</button>
		</form>
	</div>	
</body>
</html>