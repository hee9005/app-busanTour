<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원페이지</title>
<style>
button {
	background-color: orange;
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
}

table {
	border-collapse: collapse;
	margin-bottom: 30px;
	width: 100%;
}

th, td {
	border: 1px solid #ddd;
	padding: 8px;
	text-align: left;
}

th {
	background-color: #f2f2f2;
}

button.my-button {
	background-color: rgba(255, 165, 0, 0.5);
	color: white;
	border: none;
	padding: 10px 20px;
	border-radius: 5px;
	cursor: pointer;
}

button.my-button:hover {
	background-color: #FF7F50;
}

.my-button1, .my-button2, .my-button3 {
	display: inline-block;
	margin-right: 10px;
}

.parent {
	display: inline-flex; /* 또는 inline-block */
	justify-content: center; /* 가운데 정렬 */
}
#btn_group1 button {
	border: 1px solid #FF7F50;
	background-color: rgba(255, 165, 0, 0.5); /* 주황색 */
	color: #000000;
	padding: 5px;
	transition: all 0.3s ease-in-out; /* 애니메이션 속도 조절 */
}

#btn_group1 button:hover {
	color: white;
	background-color: #FF7F50;
}

#btn_group1 {
	position: absolute;
	top: 20px;
	right: 85px;
}

#btn_group2 button {
	border: 1px solid #FF7F50;
	background-color: rgba(255, 165, 0, 0.5); /* 주황색 */
	color: #000000;
	padding: 5px;
	transition: all 0.3s ease-in-out; /* 애니메이션 속도 조절 */
}

#btn_group2 button:hover {
	color: white;
	background-color: #FF7F50;
}

#btn_group2 {
	position: absolute;
	top: 20px;
	right: 15px;
}
 h2, ul {
    margin: 0 auto;
    text-align: center;
  }

  ul.my_user {
    margin-top: 20px;
  }
</style>
</head>

<body>

	<h2>마이페이지</h2>

	<ul class="my_user">
		<li>아이디 : ${id }</li>
		<li>닉네임 : ${nick }</li>
	</ul>

	<div></div>
	<table>
		<thead>
			<tr>
				<th>글번호</th>
				<th>작성자</th>
				<th>내용</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach var="item" items="${guestbook }">
				<tr>
					<td>${item.boardId }</td>
					<td>${item.writer }</td>
					<td>${item.content }</td>
				</tr>

			</c:forEach>
		</tbody>

	</table>
	<div class="parent">
		<button class="my-button1" onclick="location.href='/mypage/update'">계정
			수정</button>
		<c:forEach var="item" items="${guestbook }">
			<button class="my-button2"
				onclick="location.href='/guestbook/delete?boardId=${item.boardId}'">삭제</button>
		</c:forEach>
		<div>
			<button class="my-button3"
				onclick="location.href='/user/delete?userId=${id }'">회원탈퇴</button>
		</div>
	</div>
		<button onclick="goBack()" class="goBack">뒤로가기</button>
	<div id="btn_group2">
		<form action="/user/logout">
			<button id="login">로그아웃</button>
		</form>
	</div>

<script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>
