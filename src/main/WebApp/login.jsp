<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
	<head>
	<title>movie booking system</title>
	</head>
	<body>
		<form action="login" method = "post">
			<label>Email: </label>
			<input type="email" placeholder="Enter Email" name="email" required /><br>
			<label>Password: </label>
			<input type="password" placeholder="Enter Password" name="password" required /><br>
			<input type="submit"/>
		</form>
		<span><h4>${invalidCredentials}</h4></span>
	</body>
</html>