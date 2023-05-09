<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/loginStyle.css">

</head>
<body>
  <div class="login-wrap">
  <div class="login-html">
    <input id="tab-1" type="radio" name="tab" class="sign-in" checked><label for="tab-1" class="tab">로그인</label>
    <input id="tab-2" type="radio" name="tab" class="sign-up"><label for="tab-2" class="tab">회원가입</label>
    <div class="login-form">
      <div class="sign-in-htm">
      <form action="/user/login-task" id="login">
        <div class="group">
          <label for="id" class="label">UserId</label>
          <input name="id" type="text" class="input">
        </div>
        <div class="group">
          <label for="pass" class="label">Password</label>
          <input name="pass" type="password" class="input" data-type="password">
        </div>
       <c:choose>
  <c:when test="${param.cause eq 'error1'}">
    <span>아이디(로그인 전용 아이디) 또는 비밀번호를 잘못 입력했습니다.
    입력하신 내용을 다시 확인해주세요.</span>
  </c:when>
  <c:when test="${param.cause eq 'error3'}">
<span>중복된 아이디가 있습니다</span>
  </c:when>
       </c:choose>
        <div class="group">
          <input type="submit" class="button" value="Sign In">
        </div>
      </form>
      </div>
    <div class="sign-up-htm">
  <form action="/user/join-task" method="post" onsubmit="return validateForm()">
    <div class="group">
      <label for="id" class="label">UserId</label>
      <input type="text" id="id" name="id" pattern="[a-zA-Z][a-zA-Z0-9]{4,}" required>
      <span>ID는 영문자로 시작하고, 최소 5자리 이상이어야 합니다.</span>
    </div>
    <div class="group">
      <label for="pass" class="label">Password</label>
      <input type="password" id="password" name="password" pattern="[a-zA-Z0-9]{4,}" required>
      <span>비밀번호는 영문자와 숫자가 쓰여야하고, 최소 4자리 이상이어야 합니다.</span>
    </div>
    <div class="group">
      <label for="nick" class="label">UserNick</label>
      <input type="text" id="nick" name="nick" pattern="[a-zA-Z0-9가-힣]{4,}" required>
      <span>닉네임은 최소 4자리 이상이어야 하며, 영문자, 한글, 숫자만 입력 가능합니다</span>
    </div>
    <div class="group">
      <input type="submit" class="button" value="Sign Up">
    </div>
  </form>
  <span id="error-message"></span>
</div>
</div>
</div>
</div>
</body>
</html>