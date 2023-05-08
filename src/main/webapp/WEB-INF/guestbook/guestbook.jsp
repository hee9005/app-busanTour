<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>방명록</title>
	<link rel="stylesheet" href="basic.css">
	<link rel="stylesheet" href="/resource/guestbook.css?<%=System.currentTimeMillis()%>">
</head>
<body>
  <h1 class="my_title">방 명 록</h1>
  <hr id="title">

  <a href="/guestbook/list" class="my_link"><h2 class="my_subtitle">방명록 목록</h2></a>
  <a href="/guestbook/write" class="my_link"><h2 class="my_subtitle">방명록 작성</h2></a>
  <a href="/index" class="my_link"><h2 class="my_subtitle">홈으로</h2></a>
</body>
</html>

