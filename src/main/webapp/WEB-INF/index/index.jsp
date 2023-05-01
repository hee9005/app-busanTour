<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/style.css">
</head>
<body>
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
	<div id="indexButton">
	<form action="/index">
		<button>전체글</button>
	</form>
	</div>
	<div id="guestButton">
		<form action="/guestbook">
			<button id="guestbook">방명록</button>
		</form>
	</div>
	
  <div>부산 여행 정보 서비스</div>
  <div style="display: flex; flex-wrap: wrap;" id="attractions">
    <c:forEach items="${festivals}" var="obj">
      <div class="festival-item" onclick="location.href='/detail?no=${obj.UC_SEQ}'">
        <div class="title">${obj.MAIN_TITLE}</div>
        <div class="image-wrapper">
          <img src="${obj.MAIN_IMG_THUMB}" alt="${obj.MAIN_TITLE}" />
        </div>
        <div class="address">${obj.ADDR1}</div>
        <div class="description">${obj.ITEMCNTNTS}</div>
      </div>
    </c:forEach>
    <c:forEach items="${attractions}" var="obj">
      <div class="attraction-item" onclick="location.href='/detail?no=${obj.UC_SEQ}'">
        <div class="title">${obj.MAIN_TITLE}</div>
        <div class="image-wrapper">
          <img src="${obj.MAIN_IMG_THUMB}" alt="${obj.MAIN_TITLE}" />
        </div>
        <div class="address">${obj.ADDR1}</div>
        <div class="description">${obj.ITEMCNTNTS}</div>
      </div>
    </c:forEach>
    <c:forEach items="${foods}" var="obj">
      <div class="attraction-item" onclick="location.href='/detail?no=${obj.UC_SEQ}'">
        <div class="title">${obj.MAIN_TITLE}</div>
        <div class="image-wrapper">
          <img src="${obj.MAIN_IMG_THUMB}" alt="${obj.MAIN_TITLE}" />
        </div>
        <div class="address">${obj.ADDR1}</div>
        <div class="description">${obj.ITEMCNTNTS}</div>
      </div>
    </c:forEach>
  </div>

</body>
</html>