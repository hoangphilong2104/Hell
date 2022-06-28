<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login Suscess</h1>
	<c:set var = "email" value = "${email }"/>
	<p>Login suscess and email is "${email }"</p>
	<form action="/Hell/user/login" method = "get" >
		<input type="submit" value = "Log out">
	</form><br>
	<form action="/Hell/user">
		<input type="submit" value = "Menu">
	</form><br>
</body>
</html>