<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<html>
	<head>
		<title>Movie Booking System</title>
	</head>
	<body>
		<form action="admin" method="post" >
			<input type="text" name="movieName" placeholder="Enter movie name" required/><br>
			<input type="text" name="author" placeholder="Enter director name" required/><br>
			<textarea  name="description" rows="4" cols="50" placeholder="Enter movie description" required> </textarea><br>
			<input type="submit"/>
		</form>
	</body>
</html>