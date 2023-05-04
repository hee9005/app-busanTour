<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/style.css">
</head>
<body>
		<div class="container">
			<div class="details">
			<h2>축제명: ${item.PLACE.toString()}</h2>
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
						<td>운영기간</td>
						<td>${item.USAGE_DAY}</td>
					</tr>
					<tr>
						<td>이용 요일 및 시간</td>
						<td>${item.USAGE_DAY_WEEK_AND_TIME}</td>
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
</body>
</html>