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
			   <a href="/guestbook/list?arr=writed">등록순</a>
			   </div>
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
			   
			<div>
			<c:set var="currentPage" value="${empty param.page ? 1: param.page }"/>
			<c:if test="${existPrev }">
					<a href="/guestbook/list?page=${start -1 }">◁</a>
			</c:if>
			<c:forEach begin="${start }" end="${last }" var="p">
			<c:choose>
				<c:when test="${p eq currentPage }">
					${p }
				</c:when>
				<c:otherwise>
					<a href="/guestbook/list?page=${p }">${p }</a> 
				</c:otherwise>
			</c:choose>
			</c:forEach>
			<c:if test="${existNext }">
					<a href="/guestbook/list?page=${last + 1 }">▷</a>
			</c:if>
			</div>
</table>
</div>
</body>
</html>