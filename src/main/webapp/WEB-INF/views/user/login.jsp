<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form action="/user/login-task">
	    <h2>로그인하기</h2>
		<div>
			아이디 : <input type="text" name="id"/>
		</div>
		<div>
			비밀번호 : <input type="password" name="pass"/>
		</div>
		 <button type = "submit">취소</button>
		 <button type = "submit">로그인</button>
	</form>
</body>
</html>