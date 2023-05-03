<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/style.css">

<style>
  .container {
        display: flex;
        flex-wrap: wrap;
        justify-content: center;
        align-items: stretch;
        margin: 0 auto;
        max-width: 1000px;
      }
      .details {
        flex: 2;
        padding: 20px;
        display: flex;
        flex-direction: column;
        align-items: center;
      }


</style>

</head>
<body>
<div class="container">
        <div class="details">
	<c:choose>
		<c:when test="${logon eq false }">
			<div id="btn_group1">
				<form action="/user/login">
					<button id="login">로그인</button>
				</form>
			</div>
			<div id="btn_group2">
				<form action="/user/join">
					<button id="join">회원가입</button>
				</form>
			</div>
		</c:when>
		<c:when test="${logon eq true }">
			<div id="btn_group1">
				<form action="/user/login">
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
	<div id="indexButton">
	<form action="/index">
		<button>전체글</button>
	</form>
	</div>
	<div id="attractionButton">
	<form action="/attraction">
		<button>명소</button>
	</form>
	</div>
	<div id="festivalButton">
	<form action="/festival">
		<button>축제</button>
	</form>
	</div>
	<div id="foodButton">
	<form action="/food">
		<button>맛집</button>
	</form>
	</div>
	<div id="guestButton">
		<form action="/guestbook">
			<button id="guestbook">방명록</button>
		</form>
	</div>
	
  <h1>부산 여행 정보 서비스</h1>
  <div style="display: flex; flex-wrap: wrap;" id="attractions">
    
    <c:forEach items="${attractions}" var="obj">
      <div class="attraction-item" onclick="location.href='/attraction-task?no=${obj.UC_SEQ}'">
        <div class="title">${obj.MAIN_TITLE}</div>
        <div class="image-wrapper">
          <img src="${obj.MAIN_IMG_THUMB}" alt="${obj.MAIN_TITLE}" />
        </div>
        <div class="address">${obj.ADDR1}</div>
        <div class="description">${obj.ITEMCNTNTS}</div>
      </div>
    </c:forEach>
   </div>
   
  </div>
</div>
</body>
</html>
