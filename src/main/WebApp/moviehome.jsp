<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>movie booking system</title>
		<link rel="stylesheet" href="home.css">
		
		<style>
/* 			/* This first section is a simple "reset". It allows the navbar to push up against the top of the browser window with no white space around it. This code also sets the default font for your whole page. Put it at the very top of your css page.  */
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

/* body{
  background: #eee;
  padding: 10px 60px;
  font-family: 'Noto Sans', sans-serif;
}

table{
  margin: 40px 0px;
  font-size: 1rem;
  color: #333;
  font-weight: 700;
  border: 1px solid #333;
  background-color: #fff;
  width: 100%;
  text-align: center;
  border-collapse: separate;
  border-spacing: 0;
  border-radius: 15px 15px 15px 15px;
  overflow: hidden;
}

table thead {
  background-color: #333;
  font-size: 2rem;
  color: #fff;
  letter-spacing: .3rem;
}

table td, table th {
  border-bottom: 1px solid #333;
  height: 80px;
  width: calc(100% / 4);
  vertical-align: middle;
}

table thead th + th,
table tbody td {
  border-right: 1px solid #333;
}

table tbody td:nth-child(4){
  border-right: none;
}

@media screen and (max-width: 768px) {
  table {
  font-size: 16px;
}
  
  table th {
  font-size: 14px;
}
  
  table td, table th {
  height: 60px;
}  */

		</style>

	</head>
	<body>
<div class="nav">
  <ul>
    <li><a href="/" class="nav-link">Home</a></li>
    <div class="topnav-right">
    <li><a href="/mybookings-${id}" class="nav-link"><em>MyBookings</em></a></li>
    <li><a href="/" class="nav-link"><em>Welcome: ${username}</em></a></li>
    <li><a href="/logout-${id}" onClick="logout" class="nav-link">Logout</a></li>
    </div>
    
  </ul>
</div> 
<h1>Book Your Show</h1>
	
 <%--        <table class="table">
      <thead>
        <tr>
          <th colspan="4">MOVIES</th>
        </tr> 
      </thead>
      <thead>
      	<th>Movie Name</th>
      	<th>Director</th>
      	<th>Movie Description</th>
      	<th>Book Tickets</th>
      </thead>
      <tbody>
        <c:forEach items="${movies}" var="movie">
                    <tr>
                        <td>
                        <img src="/imagedata/${movie.moviePhotoName}" style="width:150px; height:200px;" alt=${movie.movieName}/>
                        </td>
                        <td>${movie.author}</td>
                        <td>${movie.description}</td>
                        
                        	
                        </td>
                    </tr>

                </c:forEach>
       </tbody>
    </table> --%>
    
    <div class="Movies">
    	<c:forEach items="${movies}" var="movie">
    		<div class="itemBox">
    		<a href="/booking-${id}-${movie.movie_no}-${movie.movieName}">
    		<img src="/imagedata/${movie.moviePhotoName}"  alt=${movie.movieName}/>
    		</a>
    		
    		</div>
    	</c:forEach>
    </div>
   </body>
	
</html>