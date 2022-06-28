<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Blog Tutorial</title>
<style>
section {
	background: #cc00cc;
}
</style>
</head>
<body>
	<header>
	<h1>Test</h1>	
	<ul>
		<c:set var="id" value="${id }"/>
		<c:set var="name" value="${name }"/>
		<c:set var="email" value="${email }"/>
		<br>
			<label>Id: </label><a>${id }</a><br>
			<label>Name: </label><a>${name }</a><br>
			<label>Email: </label><a>${email }</a><br>
	</ul>
	
	</header>
	
</body>
</html>