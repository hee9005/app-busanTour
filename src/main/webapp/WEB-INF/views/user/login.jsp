<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
      <form action="/user/login-task">
        <div class="group">
          <label for="id" class="label">UserId</label>
          <input name="id" type="text" class="input">
        </div>
        <div class="group">
          <label for="pass" class="label">Password</label>
          <input name="pass" type="password" class="input" data-type="password">
        </div>
        <div class="group">
          <input id="check" type="checkbox" class="check" checked>
          <label for="check"><span class="icon"></span> 로그인 상태 유지</label>
        </div>
        <div class="group">
          <input type="submit" class="button" value="Sign In">
        </div>
      </form>
       
      </div>
      <div class="sign-up-htm">
      <form action="/user/join-task" method="post">
        <div class="group">
          <label for="id" class="label">UserId</label>
          <input name="id" type="text" class="input">
        </div>
        <div class="group">
          <label for="pass" class="label">Password</label>
          <input name="pass" type="password" class="input" data-type="password">
        </div>
        <div class="group">
          <label for="nick" class="label">UserNick</label>
          <input name="nick" type="text" class="input" >
        </div>
        <div class="group">
          <input type="submit" class="button" value="Sign Up">
        </div>
      </form>
        </div>
      </div>
    </div>
  </div>
</body>
</html>