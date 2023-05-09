<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 목록</title>
<link rel="stylesheet"
	href="/resource/list.css?<%=System.currentTimeMillis()%>">
</head>
<body>
	<div class="sort-links"></div>
	<div>
		<button onclick="location.href='/guestbook'" class="backButton button-css1">돌아가기</button>
	</div>
	<div>
		<button onclick="location.href='/guestbook/write'" class="writeButton button-css1" >작성하기</button>
	</div>
	<div>
		<button onclick="location.href='/index'" class="indexButton button-css1">홈으로</button>
	</div>
	<div class="container">
		<h1 style="font-size: 30px; font-weight: bold;">게시판</h1>
		<div>
			<table>
				<tr>
					<th width="50%">내용</th>
					<th width="10%">글쓴이</th>
					<th width="20%">작성일</th>
					<th class="th-buttons" width="20%">
						<button onclick="location.href='/guestbook/list?arr=writed'"
							class="button-css">등록순</button>
						<button onclick="location.href='/guestbook/list?arr=basic'"
							class="button-css">기본순</button>
					</th>
				</tr>
				<c:forEach items="${list}" var="list">
					<tr>
						<td>${list.content}</td>
						<td>${list.writer}</td>
						<td><fmt:formatDate value="${list.writed}"
								pattern="yyyy-MM-dd HH:mm:ss" /></td>
						<td><a
							href="/guestbook/check?boardId=${list.boardId}&caseCheck=1">수정</a>
							<a href="/guestbook/check?boardId=${list.boardId}&caseCheck=2">삭제</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
</div>
		<div class="paging">
    <c:set var="currentPage" value="${empty param.page ? 1: param.page }" />
    <c:if test="${existPrev }">
        <a href="/guestbook/list?page=${start -1 }">◁</a>
    </c:if>
    <c:forEach begin="${start }" end="${last }" var="p">
        <c:choose>
            <c:when test="${p eq currentPage }">
                <b style="color: green">${p }</b>
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
</body>
</html>