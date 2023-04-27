<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action="/user/join-task" method="post">
	    <h2>회원가입하기</h2>
		<div>
			아이디 : <input type="text" name="id"/>
		</div>
		<div>
			비밀번호 : <input type="password" name="pass"/>
		</div>
		<div>
			닉네임 : <input type="text" name="nick"/>
		</div>
		 <button type = "reset">취소하기</button>
		 <button type = "submit">가입하기</button>
	</form>
</body>
</html>

