<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원페이지</title>
<<<<<<< HEAD
<style>
  button {
    background-color: orange;
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
  }
   table {
    border-collapse: collapse;
    margin-bottom: 30px;
    width: 100%;
  }
  
    th, td {
    border: 1px solid #ddd;
    padding: 8px;
    text-align: left;
  }
  th {
    background-color: #f2f2f2;
  }
  button.my-button {
    background-color: rgba(255, 165, 0, 0.5);
    color: white;
    border: none;
    padding: 10px 20px;
    border-radius: 5px;
    cursor: pointer;
  }
  
  button.my-button:hover {
    background-color: #FF7F50;
  }
</style>
=======

>>>>>>> 0489db9ba3b1155087b5e10d29397c0476b55fef
</head>

<body>
   <h2>마이페이지</h2>
  
		<ul class="my_user">
		   <li>아이디 : ${id }</li>
		   <li>비밀번호 : ${pass }</li>
		   <li>닉네임 : ${nick }</li>
	    </ul>

	    <div>
<<<<<<< HEAD
  <a href="/mypage/update" class="my-button">수정</a> |
  <button class="my-button" onclick="location.href='/guestbook/update?boardId=${gbook.boardId }&caseCheck=2'">삭제</button>
	</div>	
=======
			<a href="/mypage/update">수정</a> 
        </div>	
>>>>>>> 0489db9ba3b1155087b5e10d29397c0476b55fef
	   
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
  <button class="my-button" onclick="location.href='/user/delete?userId=${id }'">회원탈퇴</button>
</div>


</body>
</html>
