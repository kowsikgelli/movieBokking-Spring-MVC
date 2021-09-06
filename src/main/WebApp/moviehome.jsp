<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>movie booking system</title>
		<style>
			/* This first section is a simple "reset". It allows the navbar to push up against the top of the browser window with no white space around it. This code also sets the default font for your whole page. Put it at the very top of your css page.  */
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
    <li><a href="/" class="nav-link"><em>MyBookings</em></a></li>
    <li><a href="/" class="nav-link"><em>Welcome: ${username}</em></a></li>
    <li><a href="/logout-${id}" onClick="logout" class="nav-link">Logout</a></li>
    </div>
    
  </ul>
</div>
		<br>
		<br>
	<table border="1px" bordercolor="black" width=80% align="center">
                <tr>
                    <td>Movie Name</td>
                    <td>Movie Director</td>
                    <td>Movie Description</td>
                    <td>Book</td>
                </tr>
                <c:forEach items="${movies}" var="movie">
                    <tr>
                        <td>${movie.movieName}</td>
                        <td>${movie.author}</td>

                        <td>${movie.description}</td>
                        <td><a href="/booking-${id}-${movie.movie_no}">Book</a></td>
              
                    </tr>

                </c:forEach>
            </table> 
	</body>
	
</html>