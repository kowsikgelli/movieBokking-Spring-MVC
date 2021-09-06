<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
	<head>
		<title>movie booking system</title>
	</head>
	<body>
		<form action="register" method="post">
			<label>User Name</label>
			<input name="userName" type="text" required placeholder="Enter Username"/><br>
			<label>Email</label>
			<input name="email" type="email" required placeholder="Enter email"/><br>
			<label>Password</label>
			<input name="password" type="password" required placeholder="Enter Password"/><br>
			<label>Confirm Password</label>
			<input name="confirmPassword" type="password" required placeholder="Confirm Password"/><br>
			<input type="submit"/>
		</form>
		<span><h4>${userexists} <a href="/login">login</a></h4></span>
	</body>
</html>