<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link type="text/css" rel="stylesheet" href="static/stylesheets/style.css" />
	<title>Random Word Generator</title>
</head>
<body>
	<h1>Let's Generate some Words!</h1>
	
	<h3>Your word is: </h3>
	<div id="wordBox">
		<c:out value="${word}"/>
	</div>
	<a href="random">Generate!</a>
	<h4> You have generated <c:out value="${count}" /> words!</h4>
	
</body>
</html>