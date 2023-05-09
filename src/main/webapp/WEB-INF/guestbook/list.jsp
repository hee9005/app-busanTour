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
		<button onclick="location.href='/guestbook'" class="backButton">돌아가기</button>
	</div>
	<div>
		<button onclick="location.href='/guestbook/write'" class="writeButton">작성하기</button>
	</div>
	<div>
		<button onclick="location.href='/index'" class="indexButton">홈으로</button>
	</div>
	<c:choose>
		<c:when test="${logon eq false }">
			<div id="btn_group1">
				<form action="/user/login">
					<button id="login">로그인</button>
				</form>
			</div>
			<div id="btn_group2">
				<form action="/user/join">
					<button id="join">회원가입</button>
				</form>
			</div>
		</c:when>
		<c:when test="${logon eq true }">
			<div id="btn_group1">
			<form action="/user/mypage">
					<button id="login">마이페이지</button>
				</form>
			</div>
			<div id="btn_group2">
				<form action="/user/logout">
					<button id="login">로그아웃</button>
				</form>
			</div>
		</c:when>
	</c:choose>
	<div class="container">
		<h1>게시판</h1>
		<div>
			<table>
				<tr>
					<th>내용</th>
					<th>글쓴이</th>
					<th>작성일</th>
					<th class="th-buttons">
						<button onclick="location.href='/guestbook/list?arr=writed'"
							class="writerButton">등록순</button>
						<button onclick="location.href='/guestbook/list?arr=basic'"
							class="basicButton">기본순</button>
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
</div>
</body>
</html>