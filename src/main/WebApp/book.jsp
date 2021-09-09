<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <html>
 <head><title>Movie Booking System</title>
 <style>


 * {
  box-sizing: border-box;
  margin: 0;
  padding: 0;
}

body {
  background-color: #eee;
  font-family: 'helvetica neue', helvetica, arial, sans-serif;
  color: #222;
  
}

#form {
  max-width: 700px;
  padding: 2rem;
  box-sizing: border-box;
}

.form-field {
  display: flex;
  margin: 0 0 1rem 0;
}
label, input {
  width: 70%;
  padding: 0.5rem;
  box-sizing: border-box;
  justify-content: space-between;
  font-size: 1.1rem;
}
label {
  text-align: right;
  width: 30%;
}
input {
  border: 2px solid #aaa;
  border-radius: 2px;
}
 
 </style>
 </head>
 <body>
 	<%-- <form action="booking-${id}-${movie_no}-${movieName}" method="post">
 	<label>enter no of seats</label>
 	<input type="number" name="noOfTickets" placeholder = "enter no of tickets" required/><br>
 	<input type="submit"/>
 	</form> --%>

 		<form method="post"  id="form" class="validate" action="booking-${id}-${movie_no}-${movieName}">
  <div class="form-field">
  <label>No Of Seats</label>
    <input type="text" name="noOfTickets" id="full-name" placeholder="Enter Number Of Tickets" required />
  </div>
  <div class="form-field">
    <label for=""></label>
    <input type="submit" value="book" />
  </div>
</form>
 	
 	
 </body>
 </html>