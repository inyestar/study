<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 이유를 모르겠으나 spring-webmvc에 있는 spring-form.tld 파일 인식을 못하여 manuall하게 web-inf 파일에 추가 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:errors element="div" />
	<form:errors path="age" />
</body>
</html>