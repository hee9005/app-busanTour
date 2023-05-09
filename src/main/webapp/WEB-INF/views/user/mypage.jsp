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
   <h2>마이페이지</h2>
  
		<ul class="my_user">
		   <li>아이디 : ${id }</li>
		   <li>비밀번호 : ${pass }</li>
		   <li>닉네임 : ${nick }</li>
	    </ul>

	    <div>
			<a href="/mypage/update">수정</a> |
			<a href="/guestbook/update?boardId=${gbook.boardId }&caseCheck=2">삭제</a>
        </div>	
	   
	   <table>
	      <thead>
	      <th>글번호</th>
	      <th>작성자</th>
	      <th>내용</th>
	      </thead>
	      
	      <tbody>
     	   <c:forEach var="item" items="${guestbook }">
     	     <tr>
     	         <td>${item.boardId }</td>
     	         <td>${item.writer }</td>
     	         <td>${item.content }</td>
     	     </tr>
	 
	       </c:forEach>     
	      </tbody>
	   
	   </table>		
<div>
<a href="/user/delete?userId=${id }">회원탈퇴</a>
</div>


</body>
</html>