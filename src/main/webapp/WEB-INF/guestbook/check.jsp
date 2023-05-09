<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
<link rel="stylesheet" href="/resource/css/style.css?${millis }">
<style>
form {
  text-align: center;
}
    body {
        background-color: #f5f5f5;
        font-family: Arial, sans-serif;
    }
    
    .root {
        background-color: #fff;
        border: 1px solid #ccc;
        border-radius: 5px;
        box-shadow: 2px 2px 5px rgba(0,0,0,0.3);
        margin: 50px auto;
        max-width: 600px;
        padding: 30px;
        text-align: center;
    }
    
    h1 {
        color: #555;
        font-size: 24px;
        font-weight: normal;
        margin: 0 0 20px;
    }
    
    input[type="password"] {
        border: 1px solid #ccc;
        border-radius: 3px;
        box-shadow: inset 2px 2px 5px rgba(0,0,0,0.1);
        font-size: 16px;
        margin: 0 0 20px;
        padding: 10px;
        width: 100%;
    }
    
    button {
        background-color: orange;
        border: none;
        border-radius: 3px;
        color: #fff;
        cursor: pointer;
        font-size: 16px;
        margin: 0 0 20px;
        padding: 10px;
        transition: all 0.3s ease-in-out;
        width: 100%;
    }
    
    button:hover {
        background-color: #333;
    }
    
    p {
        color: red;
        font-size: 14px;
        margin: 10px 0 0;
    }
</style>

</head>
<body>
	<form action="/guestbook/passcheck">
	<input type="hidden" name="caseCheck" value="${caseCheck }"/>
	<input type="hidden" name="boardId" value="${boardId }"/>
		<div class="root">
			<h1>비밀번호를 입력해주세요.</h1>
			<input type="password" placeholder="비밀번호" name="pass"/>
			<button>전송</button>
			<c:if test="${param.cause eq 'error' }">
				<p>비밀번호가 틀렸습니다.</p>
			</c:if>
		</div>
	</form>
</body>
</html>