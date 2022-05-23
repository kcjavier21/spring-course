<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit</title>
</head>
<body>
	<form action="/deleteUserByEmail" method="POST">
		<table border="1">
			<tr>
				<th>Full Name</th>
				<td>
					<input type="text" name="fullName" value="<c:out value='${user.fullName}'/>"/>
				</td>
				<th>Email Address</th>
				<td>
					<input type="email" name="email" value="<c:out value='${user.email}'/>"/>
				</td>
			</tr>		
		</table>
		<button type="submit">Delete</button>
		
	</form>
</body>
</html>