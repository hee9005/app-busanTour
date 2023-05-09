<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>마이페이지</title>
  <style>
    /* 루트 컨테이너 스타일 */
    .root {
      width: 80%;
      margin: 0 auto;
      padding: 20px;
      text-align: center;
    }
    
    /* 제목 스타일 */
    h1 {
      font-size: 32px;
      margin-bottom: 30px;
    }
    
    /* 버튼 스타일 */
    button {
      font-size: 18px;
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      background-color: orange; /* 버튼 배경색을 주황색으로 변경 */
      color: white;
      margin: 10px;
    }
    
    /* "아니요" 버튼 스타일 */
    button:nth-child(2) {
      background-color: #f44336;
    }
  </style>
</head>
<body>
  <div class="root">
    <h1>탈퇴하시겠습니까?</h1>
		
    <a href="/user/delete-task?userId=${userId }"><button>예</button></a> / 
    <a href="/user/mypage"><button>아니요</button></a>
  </div>
</body>
</html>
