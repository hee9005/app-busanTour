<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.body {
	background-image:
		url('https://media.cnn.com/api/v1/images/stellar/prod/220223041055-08-tripadvisor-top-10-beaches-world.jpg?q=h_1980,w_3000,x_0,y_0/w_1280');
	background-size: cover;
	background-position: center;
	background-repeat: no-repeat;
}

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
	padding: 10px;
	display: flex;
	flex-direction: column;
	align-items: center;
}

.image-container {
	height: 360px;
	width: 100%;
	overflow: hidden;
	margin-bottom: 10px;
}

.image {
	height: 100%;
	width: 100%;
	object-fit: cover;
}

.info {
	width: 100%;
	margin-bottom: 10px;
}

.info table {
	width: 100%;
	border-collapse: collapse;
	border: 1px solid #ccc;
	background-color: #f7f7f7;
}

.info td {
	padding: 5px 10px;
	border: 1px solid #ccc;
}

.info td:first-child {
	font-weight: bold;
}

.map-container {
	height: 400px;
	width: 100%;
	margin-bottom: 10px;
}

#map {
	height: 100%;
	width: 100%;
}

@media screen and (max-width: 600px) {
	.container {
		flex-direction: column;
	}
	.details {
		flex: 1;
	}
}
</style>
</head>
<body>
<div class="body">
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