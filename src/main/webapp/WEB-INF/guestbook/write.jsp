<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 작성</title>
<link rel="stylesheet" href="/resource/weite.css?<%=System.currentTimeMillis()%>">
</head>
<body>
<c:choose>
		<c:when test="${logon eq false }">
			<div id="btn_group1">
				<form action="/user/login">
					<button id="login">로그인</button>
				</form>
			</div>
			<div id="btn_group2">
				<form action="/user/login">
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
<button class="list-btn1" onclick="location.href='/guestbook/list'">목록으로</button> 
<button class="list-btn2" onclick="location.href='/index'">전체글</button>
<h2>방명록 작성</h2>
<form action="/guestbook/write-task">
<c:choose>
<c:when test="${logon eq true }">
<input type="hidden" name="userId" placeholder="${logonUser.id }" >
	<input type="hidden" name="writer" placeholder="${logonUser.nick }" >
	<input type="hidden" name="boardPass" placeholder="${logonUser.pass }"  >
</c:when>
<c:when test="${logon eq false }">
	<input type="text" name="writer" placeholder="닉네임" >
	<input type="password" name="boardPass" placeholder="비밀번호"  >
</c:when>
</c:choose>
	
	<input type="text"name="content" placeholder="내용..."> 
	<button type="submit" class="list-btn3">등록</button>
	</form>

</body>
</html>