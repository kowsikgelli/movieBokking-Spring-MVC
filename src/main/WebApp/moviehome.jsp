<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>

<html>
	<head>
		<title>movie booking system</title>
	</head>
	<body>
		<h1>movie Home page</h1>
		<table border="1px" bordercolor="black" width=80% align="center">
                <tr>
                    <td>Movie Name</td>
                    <td>Movie Director</td>
                    <td>Movie Description</td>
                </tr>
                <c:forEach items="${movies}" var="movie">

                    <tr>
                        <td><c:out value="${movie}" /></td>
                        <td><c:out value="${movie}" /></td>

                        <td><c:out value="${movie}" /></td>
              
                    </tr>

                </c:forEach>
            </table>
	</body>
	
</html>