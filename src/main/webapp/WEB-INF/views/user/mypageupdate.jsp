<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
<title>회원페이지</title>
</head>
  <style>
    /* 여기에 위에서 작성한 CSS를 추가하십시오. */
    form {
  display: flex;
  flex-direction: column;
  align-items: center;
  font-family: Arial, sans-serif;
  margin: 20px;
}

input[type="text"],
input[type="password"] {
  padding: 10px;
  margin-bottom: 10px;
  border-radius: 5px;
  border: 1px solid gray;
  font-size: 16px;
  transition: border-color 0.3s ease-in-out;
}

input[type="text"]:hover,
input[type="password"]:hover {
  border-color: #FF7F50;
}

input[type="submit"],
input[type="reset"] {
  padding: 10px 20px;
  margin-bottom: 10px;
  border: none;
  border-radius: 5px;
  background-color: #FF7F50;
  color: white;
  font-size: 16px;
  cursor: pointer;
  transition: background-color 0.3s ease-in-out;
}

input[type="submit"]:hover,
input[type="reset"]:hover {
  background-color: transparent;
  border: 1px solid #FF7F50;
  color: #FF7F50;
}
    body {
  font-family: Arial, sans-serif;
  margin: 0;
  padding: 0;
}

h2 {
  text-align: center;
  margin-top: 50px;
}

table {
  border-collapse: collapse;
  margin: 50px auto;
}

th,
td {
  border: 1px solid gray;
  padding: 10px;
}

th {
  background-color: #FF7F50;
  color: white;
}
    
  </style>
<body>
   <h2>마이페이지 수정</h2>
  
	<form action="/mypage/update-task">
	   <table align="left" >
    <tr>
    <input type="hidden" name="id" value="${user.id }"/>
     <td width="200"><p align="right" >아이디</td>
     <td width="400"><input   type="text" name="id" value="${user.id}" disabled ></td>
     
    </tr>
    <tr>
     <td width="200"><p align="right" >비밀번호</td>
     <td width="400"><input   type="password" name="pass" value="${user.pass}" ></td>
    </tr>
    <tr>
     <td width="200"><p align="right" >닉네임</td>
     <td width="400"><input   type="text" name="nick" value="${user.nick}" ></td>
    </tr>
    
    
    <tr align="center" >
    <td colspan="2" width="400"><input type="submit" value="수정하기" >
       <input type="reset" value="다시입력" > </td>
    </tr>
       </table>      
	</form>	
</body>
