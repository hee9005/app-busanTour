<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>방명록 목록</title>
    <link rel="stylesheet" href="/resource/list.css?<%=System.currentTimeMillis()%>">
</head>
<body>
<div align="left">
			<a href="/guestbook/list?arr=writed">등록순</a>
			<a href="/guestbook/list?arr=basic">기본순</a>
		</div>
		<div>
		<a href= "/guestbook"> 돌아가기</a>
		</div>
		<div>
		<a href= "/guestbook/write">작성하기</a>
		</div>
		<div>
		<a href= "/index">홈으로</a>
		</div>
<div class="container">
    <table>
        <thead>
        <tr>
            <th>내용</th>
            <th>글쓴이</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="list">
            <div class="my_div">
                <ul class="my_ul">
                    <li>글번호 : ${list.boardId }</li>
                    <li>작성자 : ${list.writer }</li>
                    <li>내용 : ${list.content }</li>
                    <li><fmt:formatDate value="${list.writed}" pattern="yyyy-MM-dd HH:mm:ss" /></li>
                    <li>
                        <a href="/guestbook/check?boardId=${list.boardId}&caseCheck=1" >수정</a>
                        <a href="/guestbook/check?boardId=${list.boardId}&caseCheck=2" >삭제</a>
                    </li>
                </ul>
            </div>
        </c:forEach>
        </tbody>
    </table>
    <div style="padding-top: 22px;text-align: center;">
			<c:set var="currentPage" value="${empty param.page ? 1: param.page }"/>
			<c:if test="${existPrev }">
					<a href="/guestbook/list?page=${start -1 }">◁</a>
			</c:if>
			<c:forEach begin="${start }" end="${last }" var="p">
			<c:choose>
				<c:when test="${p eq currentPage }">
					<b style="color:green">${p }</b>
				</c:when>
				<c:otherwise>
					<a href="/guestbook/list?page=${p }&arr=${abc}">${p }</a> 
				</c:otherwise>
			</c:choose>
			</c:forEach>
			<c:if test="${existNext }">
					<a href="/guestbook/list?page=${last + 1 }&arr=${abc}">▷</a>
			</c:if>
			</div>
</div>
</body>
</html>