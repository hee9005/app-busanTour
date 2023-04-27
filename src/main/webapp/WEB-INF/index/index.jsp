<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#login {
	border-top-left-radius: 5px;
	border-bottom-left-radius: 5px;
}

#join {
	border-top-right-radius: 5px;
	border-bottom-right-radius: 5px;
}

#btn_group button {
	border: 1px solid skyblue;
	background-color: rgba(0, 0, 0, 0);
	color: skyblue;
	padding: 5px;
}

#btn_group button:hover {
	color: white;
	background-color: skyblue;
}

div:nth-child(1) {
	position: absolute;
	top: 20px;
	right: 15px;
	
}
#guestButton {
  text-align: center;
}

#guestButton button {
  border: 1px solid skyblue;
  background-color: rgba(0, 0, 0, 0);
  color: skyblue;
  padding: 5px;
}

#guestButton button:hover {
  color: white;
  background-color: skyblue;
}
</style>
</head>
<body>
	<div id="btn_group">
		<a href="/user/login">
			<button id="login">로그인</button>
		</a> <a href="/user/join">
			<button id="join">회원가입</button>
		</a>
	</div>
	<div id="guestButton">
	<a href="/guestbook">
	<button id="guestbook">방명록</button>
	</a>
	</div>
</body>
</html>