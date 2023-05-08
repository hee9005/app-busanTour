<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<div class="root">
		<h1>글 삭제</h1>
		
		<a href="/guestbook/delete-task?boardId=${boardId }"><button>예</button></a> / 
		<a href="/guestbook/list"><button>아니요</button></a>
	</div>
</body>
</html>