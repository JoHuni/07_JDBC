<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
    <div class="login-container">
        <h2>로그인</h2>
        <form action="/bbs/login" method="POST">
            <div class="input-group">
                <label for="username">아이디</label>
                <input type="text" id="username" name="userId" placeholder="아이디를 입력해주세요.">
            </div>
            <div class="input-group">
                <label for="password">비밀번호</label>
                <input type="password" id="password" name="userPw" placeholder="비밀번호를 입력해주세요.">
            </div>
            <button type="submit">로그인</button>
        </form>
    </div>
</body>
  <c:if test="${not empty message}" >
    <script>
      alert("${message}");
    </script>

    <c:remove var="message" />
  </c:if>
</html>
