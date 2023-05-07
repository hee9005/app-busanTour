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
                        <a href="/guestbook/update?boardId=${list.boardId}&caseCheck=1" >수정</a>
                        |
                        <a href="/guestbook/update?boardId=${list.boardId}&caseCheck=2">삭제</a>
                    </li>
                </ul>
            </div>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
