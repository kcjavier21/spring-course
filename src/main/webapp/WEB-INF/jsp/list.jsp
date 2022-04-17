<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>List of Users</title>
</head>
<body>
	<div class="container">
		<table class="table">
			<tr>
				<th scope="col">Full Name</th>
				<th scope="col">Email</th>
				<th scope="col">Action</th>
			</tr>
			<c:forEach var="list" items="${listOfUsers}">
				<tr>
					<td scope="row">${list.fullName}</td>
					<td scope="row">${list.email}</td>
					<td scope="row">
						<a href="/editUser?userId=${list.userId}">Edit</a>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>	
</body>
</html>