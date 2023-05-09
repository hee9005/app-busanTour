<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<style>
form {
  text-align: center;
}
.my_ul {
  list-style: none;
  margin: 0;
  padding: 0;
  font-size: 16px;
  font-weight: bold;
}

.my_ul li {
  display: inline-block;
  margin-right: 20px;
}

input[type=text] {
  width: 500px;
  height: 40px;
  font-size: 16px;
  padding: 5px 10px;
  margin-top: 20px;
  margin-bottom: 20px;
  border-radius: 5px;
  border: 1px solid #ccc;
}

button {
  display: inline-block;
  background-color: orange;
  color: #fff;
  padding: 10px 20px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}

</style>
</head>
<body>
	<h1 align="center">글 수정</h1>
	<c:if test="${param.cause eq 'error' }">
		글의 양식이 맞지 않습니다. 다시 작성해주세요
	</c:if>
	<form action="/guestbook/update-task">
		<input type="hidden" name="boardId" value="${gbook.boardId }" />
	<ul class="my_ul">
		<li>글번호 : ${gbook.boardId }</li>
		<li>작성자 : ${gbook.writer }</li>
	</ul>
	<input type="text" name="content" placeholder="${gbook.content }">
	<div align="center">
		<button>수정하기</button>
	</div>
	</form>
</body>
</html>