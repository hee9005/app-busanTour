<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/guestbook-task">
	<input type="text" name="writer" placeholder="닉네임">
	<input type="password" name="boardPass" placeholder="비밀번호" >
	<input type="text"name="content" placeholder="내용..."> 
	<button type="submit">등록</button>
	</form>
</body>
</html>