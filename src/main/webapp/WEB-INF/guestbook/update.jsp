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
	<h1>글 수정</h1>
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
	<div align="left">
		<button>수정하기</button>
	</div>
	</form>
</body>
</html>