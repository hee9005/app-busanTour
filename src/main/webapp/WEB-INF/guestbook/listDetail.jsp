<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<div>
	 ${gbook.boardId }/${gbook.content }
</div>
<div>
					<a href="/guestbook/update?boardId=${gbook.boardId }&caseCheck=1">수정</a> |
					<a href="/guestbook/update?boardId=${gbook.boardId }&caseCheck=2">삭제</a>
				</div>	


</body>
</html>