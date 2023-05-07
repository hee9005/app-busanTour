<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 수정</title>
</head>
<body>
<form action="/guestbook/update-task">
    
    <input type="hidden" name="boardId" value="${gbook.boardId }"/>
	<input type="text" name="writer" placeholder="닉네임">
	<input type="text"name="content" placeholder="내용..."> 
	<button type="submit">수정</button>

</form>
</body>
</html>