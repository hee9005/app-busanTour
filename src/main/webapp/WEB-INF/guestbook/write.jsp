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
	<button type="submit">등록</button>
	</form>

</body>
</html>