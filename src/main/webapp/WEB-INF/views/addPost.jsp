<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Add Post</h1>
	<form action="/Hell/user/post">
		<input type="submit" value = "Back">
	</form><br>
	<form action="/Hell/user/post/add" method = "post"> 
		<input type="text" name = "title">
		<input type="text" name = "article">
		<input type="submit" value = "Add"> 
	</form><br>
	
</body>
</html>