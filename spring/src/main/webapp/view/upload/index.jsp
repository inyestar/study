<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/upload/file" method="POST" encType="multipart/form-data">
		<input type="text" name="title"/><br/>
		<input type="file" name="f"/><br/>
		<input type="submit" value="send">
	</form>
</body>
</html>