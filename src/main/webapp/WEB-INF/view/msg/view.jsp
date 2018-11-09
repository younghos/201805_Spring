<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>view.jsp</title>
<c:set var="lang" value="${param.lang == null ? 'ko' : param.lang }"/>
</head>
<body>
	hello : <spring:message code="hello" /> <br>
	visitor : <spring:message code="visitor" arguments="test"/> <br>
<!-- 	아이디 : <input type="text" value="brown" /><br> -->
<!-- 	내용   : <input type="text" value="content" /> <br> -->

<form action="/messageView" method="POST">
	<select name="lang">
		<option value="ko" ${lang == 'ko' ? 'selected' : '' }>한국어</option>
		<option value="ja" ${lang == 'ja' ? 'selected' : '' }>日本語</option>
		<option value="en" ${lang == 'en' ? 'selected' : '' }>English</option>
	</select>
	<input type="submit" value="전송" />
</form>
</body>
</html>