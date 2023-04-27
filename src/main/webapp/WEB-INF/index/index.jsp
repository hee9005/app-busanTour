<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<div >부산 여행 정보 서비스</div>
	<div style="display: flex; flex-wrap: wrap;">
		<c:forEach items="${attractions }" var="obj">
		<div style="width: 33.3%; padding: 10px; height: 280px; cursor: pointer;" 
					onclick="location.href='/detail?no=${obj.ucSeq}'">
			<div
				style="width: 100%; border: 1px solid #dddddd; padding: 4px; height: 100%;">
				<div style="height: 10%">
					<b>${obj.mainTitle }</b>
				</div>
				<div style="height: 50%">
					<img src="${obj.mainImgThumb }" style="height: 100%;" />
				</div>
				<div style="height: 10%">
					<b>${obj.usageDayWeekAndTime }</b>
				</div>
				<div
					style="height: 10%; text-overflow: ellipsis; white-space: nowrap; overflow: hidden">
					<span>${obj.addr1 }</span>
				</div>
				<div style="height: 20%; text-overflow: ellipsis; white-space: nowrap; overflow: hidden">
				 	<c:if test="${obj.itemcntnts }"></c:if></div>

			</div>
		</div>
		</c:forEach>
	</div>
</body>
</html>