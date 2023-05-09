<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>마이페이지</title>
</head>
<body>
	<div class="root">
		<h1>탈퇴하시겠습니까?</h1>
		
		<a href="/user/delete-task?userId=${userId }"><button>예</button></a> / 
		<a href="/user/mypage"><button>아니요</button></a>
	</div>

</body>
</html>