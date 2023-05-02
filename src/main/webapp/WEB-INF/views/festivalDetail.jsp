<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	margin: 0;
}

.container {
	display: flex;
}

.details {
	flex: 3;
	padding: 4px;
}
.image-container {
	height: 360px;
	overflow: hidden;
}
.info {
	margin: 10px 0;
}

.info table {
	border-collapse: collapse;
}

.info td {
	padding: 5px 10px;
	border: 1px solid #ccc;
}

.info td:first-child {
	font-weight: bold;
	background-color: #f7f7f7;
}
.image {
	height: 450px;
	width: 60%;
	object-fit: cover
</style>
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
					</div>
					</div>
</body>
</html>