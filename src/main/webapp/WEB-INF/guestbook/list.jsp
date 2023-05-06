<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록</title>
</head>
<body>
<div>
<table>
				<tr>
					<th>내용</th>
					<th>글쓴이</th>
					<th>작성일</th>
				</tr>
				
				<c:forEach items="${list }" var="list">
						<tr>
							<td>${list.boardId }"><a href="/guestbook/listDetail?boardId=${list.boardId }">${list.content }</a></td>
							<td width="15%">${list.writer }</td>
							<td width="15%">${list.writed }</td>
						</tr>
			   </c:forEach>
</table>
</div>
</body>
</html>