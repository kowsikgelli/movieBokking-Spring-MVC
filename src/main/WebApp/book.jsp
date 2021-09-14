<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <html>
 <head><title>Movie Booking System</title>
 <link rel="stylesheet" href="book.css">
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
html, body, div, p, ul, li {
  margin: 0;
  padding: 0;
  border: 0;
  font-size: 100%;
  font: inherit;
  vertical-align: baseline;
  font-family: 'Roboto', sans-serif;
  font-weight: 100;
}

/* This class is applied to the containing div <div class="nav"> and is used to set the background color and height of the navbar */
.nav {
  background: #000;
  height: 60px; /* set same as height & line-height below */
}

/* This rule centers the nav items verticaly in the bar with the height and line height properties. Spacing between the nav items is controlled by setting right and left padding.  */
.nav li {
  display: inline-block;
  list-style: none;
  height: 60px; /* should be the same as line-height */
  line-height: 60px; /* should be the same as height */
  padding: 0 40px; /* "0" sets top and bottom padding to none */
}

/* :hover allows you change the background color of the nav items when you mouse over them. Play around with the transition value to change the speed of the hover transition. */
.nav li:hover {
  background: red;
  transition: background .3s;
}

/* This rule is applied to the link <a> tag. It lets you turn off the link underline and set the link text color. */
.nav-link {
  color: #fff;
  text-decoration: none;
}
/* Add a black background color to the top navigation */
.topnav {
    background-color: #333;
    overflow: hidden;
}

/* Style the links inside the navigation bar */
.topnav a {
  float: left;
  color: #f2f2f2;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
  font-size: 17px;
}

/* Change the color of links on hover */
.topnav a:hover {
  background-color: #ddd;
  color: black;
}

/* Add a color to the active/current link */
.topnav a.active {
  background-color: #04AA6D;
  color: white;
}

/* Right-aligned section inside the top navigation */
.topnav-right {
  float: right;
} 
 
 </style>
 </head>
 <body>
 	<div class="nav">
		  <ul>
		    <li><a href="/" class="nav-link">Home</a></li>
		    <div class="topnav-right">
		    <li><a href="/moviehome-${id}" class="nav-link"><em>Movies</em></a></li>
		    <li><a href="/mybookings-${id}" class="nav-link"><em>MyBookings</em></a></li>
		    <li><a href="/logout-${id}" onClick="logout" class="nav-link">Logout</a></li>
		    </div>
		  </ul>
	</div> 
	<br>
	<div class="header_menu">
    <div class="left_screen">
        <img src="/imagedata/${movie.moviePhotoName}"  alt=${movie.movieName}"/>
        <br>
        <br>
        <br>
        <div class="movie-details">
        	<h2>Movie Name : ${movie.movieName}</h2>
        	<br>
        	<h3>Director : ${movie.author}</h3><br>
        	<h3>Movie Description : ${movie.description}</h3>
        </div>
    </div>
    <div class="right_screen">
    	<div class="inside-right">
        <iframe width="1160" height="650" src="${movie.trailerLink}" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
        </iframe>
        <form method="post"  id="form" class="validate" action="booking-${id}-${movie_no}-${movieName}">
  				<h3>${ticketMessage}</h3>
  			<div class="form-field">
  				<label>No Of Seats</label>
    			<input type="text" name="noOfTickets" id="full-name" placeholder="Enter Number Of Tickets" required />
  			</div>
	  		<div class="form-field">
	    		<label for=""></label>
	    		<input type="submit" value="book" />
	  		</div>
		</form>
    	</div>
    </div>
    
    <div class="clearfix"></div>
</div>
 		<%--  --%>
 </body>
 </html>