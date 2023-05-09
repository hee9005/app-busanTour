<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
  background-color: #f7f7f7;
  font-family: Arial, sans-serif;
  font-size: 16px;
  line-height: 1.6;
}

div {
  padding: 20px;
  margin: 50px auto;
  max-width: 600px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #fff;
  text-align: center;
}

a {
  display: inline-block;
  margin: 10px;
  padding: 10px;
  color: #fff;
  background-color: #FF5500;
  border-radius: 5px;
  text-decoration: none;
}

a:hover {
  background-color: #FF7E00;
}

</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div>
	 ${gbook.boardId }/${gbook.content }
</div>
<div>
			<a href="/guestbook/update?boardId=${gbook.boardId }&caseCheck=1">수정</a> |
			<a href="/guestbook/update?boardId=${gbook.boardId }&caseCheck=2">삭제</a> |
			<a href="/guestbook/list">목록으로</a>
</div>

</body>
</html>