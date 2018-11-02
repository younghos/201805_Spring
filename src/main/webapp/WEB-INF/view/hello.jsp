<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>hello.jsp</title>
</head>
<body>
	hello.jsp
	
	<h2>rangers</h2>
	<c:forEach items="${rangers }" var="ranger">
		${ranger }<br>
	</c:forEach>	
	
	<h2>/hello/request</h2>
	<form action="/hello/request" method="post">
		<input type="text" name="userId" value="brown"/>
		<input type="password" name="pass" value="brownpass"/>
		<input type="submit" value="전송" />
	</form>
	
	<h2>/hello/vo</h2>
	<form action="/hello/vo" method="post">
		<input type="text" name="userId" value="brown"/>
		<input type="password" name="pass" value="brownpass"/>
		<input type="submit" value="전송" />
	</form>
</body>
</html>