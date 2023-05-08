<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원페이지</title>
</head>
<body>
   <form action="/user/mypage">
	    <h2>마이페이지</h2>
		<div>
			아이디 : <input type="text" name="id"/>
		</div>
		<div>
			비밀번호 : <input type="password" name="pass"/>
		</div>
		<div>
			닉네임 : <input type="text" name="nick"/>
		</div>
		
	</form>

</body>
</html>