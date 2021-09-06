<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <html>
 <head><title>Movie Booking System</title></head>
 <body>
 	<form action="booking-${id}-${movie_no}" method="post">
 	<label>enter no of seats</label>
 	<input type="number" name="noOfTickets" placeholder = "enter no of tickets" required/><br>
 	<input type="submit"/>
 	</form>
 </body>
 </html>