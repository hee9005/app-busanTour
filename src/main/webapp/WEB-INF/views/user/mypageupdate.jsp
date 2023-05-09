<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원페이지</title>
</head>
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
    
    
    <tr align="left" >
    <td colspan="2" width="400"><input type="submit" value="수정하기" >
       <input type="reset" value="다시입력" > </td>
    </tr>
       </table>      
	</form>	
	

</body>
</html>