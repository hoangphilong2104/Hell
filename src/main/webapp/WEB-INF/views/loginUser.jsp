<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Login</h1>
	<form action="/Hell">
		<input type="submit" value = "Back">
	</form><br>
	<ul>
	
	
	<form action="/Hell/user/login" method = "post" >
		<label>Username: </label><input type="text" name = "username" required="required">
		<label>Password: </label><input type="text" name = "password" required="required">
		<input type="submit" value = "Login">
	</form><br>
	<form action="/Hell/user/register"><input type="submit" value = "Register"></form>
	<br>
	
	</ul>
	
</body>
</html>