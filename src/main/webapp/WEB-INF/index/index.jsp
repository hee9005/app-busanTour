<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/* 로그인/회원가입 버튼 스타일 */
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
  transition: all 0.3s ease-in-out; /* 애니메이션 속도 조절 */
}

#btn_group button:hover {
  color: white;
  background-color: skyblue;
}

#btn_group {
  position: absolute;
  top: 20px;
  right: 15px;
}

/* 방명록 버튼 스타일 */
#guestButton {
  text-align: center;
  position: fixed;
  top: 30%;
  right: 30%;
}

#guestButton button {
  border: 1px solid skyblue;
  background-color: rgba(0, 0, 0, 0);
  color: skyblue;
  font-size: 20px;
  padding: 10px 20px;
  transition: all 0.3s ease-in-out; /* 애니메이션 속도 조절 */
}

#guestButton button:hover {
  color: white;
  background-color: skyblue;
}

/* 관광지 목록 스타일 */

#attractions {
  display: flex;
  flex-wrap: wrap;
   position: fixed;
  bottom: 0;
  left: 0;
  width: 100%;
  background-color: #fff; /* 화면 아래쪽이므로 백그라운드 색상 추가 */
}

#attractions > div {
  width: calc(20% - 20px); /* 오른쪽과 왼쪽에 10px의 패딩을 더해줌 */
  margin: 10px;
  padding: 10px;
  height: 250px;
  cursor: pointer;
  box-sizing: border-box; /* 패딩값을 포함해서 계산하도록 설정 */
}

#attractions > div:hover {
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.3); /* 호버시 그림자 추가 */
}

#attractions > div > div:first-child {
  height: 13%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
}

#attractions > div > div:nth-child(2) {
  height: 60%;
  display: flex;
  justify-content: center;
  align-items: center;
}

#attractions > div > div:nth-child(2) > img {
  max-height: 100%;
  max-width: 100%;
  object-fit: contain; /* 이미지 비율 유지 */
}

#attractions > div > div:nth-child(3) {
  height: 10%;
  display: flex;
  justify-content: center;
  align-items: center;
  font-weight: bold;
}

#attractions > div > div:nth-child(4) {
  height: 10%;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

#attractions > div > div:last-child {
  height: 30%;
  text-overflow: ellipsis;
  white-space: nowrap;
  overflow: hidden;
}

.box {
    width: 20%;
    height: 300px;
    padding: 20px;
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

  <div>부산 여행 정보 서비스</div>
  <div style="display: flex; flex-wrap: wrap;" id="attractions">
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
  </div>

</body>
</html>