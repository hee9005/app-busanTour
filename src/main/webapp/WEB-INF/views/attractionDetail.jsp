<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${item.PLACE.toString()}- 여행 정보</title>
<link rel="stylesheet" href="/resource/style.css">
</head>
<body>
<c:choose>
		<c:when test="${logon eq false }">
			<div id="btn_group1">
				<form action="/user/login">
					<button id="login">로그인</button>
				</form>
			</div>
			<div id="btn_group2">
				<form action="/user/login">
					<button id="join">회원가입</button>
				</form>
			</div>
		</c:when>
		<c:when test="${logon eq true }">
			<div id="btn_group1">
			<form action="/user/mypage">
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
	<button onclick="goBack()" class="goBack">뒤로가기</button>
	<div class="container">
		<div class="details">
			<h1>${item.PLACE.toString()}
				(조회수:
				<c:forEach items="${views}" var="view">
					<c:choose>
						<c:when test="${view.viewOrder == 1}">
      1
    </c:when>
						<c:otherwise>
      ${view.viewOrder}
    </c:otherwise>
					</c:choose>
				</c:forEach>
				)
			</h1>
			<div class="image-container">
				<img src="${item.MAIN_IMG_NORMAL}" class="image" />
			</div>
			<div class="info">
				<table>
					<tr>
						<td>주소</td>
						<td>${item.ADDR1}</td>
					</tr>
					<tr>
						<td>교통정보</td>
						<td>${item.TRFC_INFO}</td>
					</tr>
					<tr>
						<td>편의시설</td>
						<td>${item.MIDDLE_SIZE_RM1}</td>
					</tr>
					<tr>
						<td>상세내용</td>
						<td>${item.ITEMCNTNTS}</td>
					</tr>
				</table>
			</div>
			<div class="map-container">
				<div id="map"></div>

			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=e3146ff4087aa7872f30db1c7c6d644d"></script>
	<script type="text/javascript">
      const container = document.querySelector('#map'), // 지도를 표시할 div 
      mapOption = { 
          center: new kakao.maps.LatLng(${item.LAT}, ${item.LNG}), // 지도의 중심좌표
          level: 3 // 지도의 확대 레벨
      };

      let map = new kakao.maps.Map(container, mapOption); // 지도를 생성합니다

      // 마커가 표시될 위치입니다 
      let markerPosition  = new kakao.maps.LatLng(${item.LAT}, ${item.LNG}); 

      // 마커를 생성합니다
      let marker = new kakao.maps.Marker({
          position: markerPosition
      });

      // 마커가 지도 위에 표시되도록 설정합니다
      marker.setMap(map);
    </script>
    <script>
function goBack() {
  window.history.back();
}
</script>
</body>
</html>