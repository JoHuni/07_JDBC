<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>아이디 찾기</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
    <div class="login-container">
        <h2>비밀번호 찾기</h2>
        <form action="/bbs/findPw" method="POST">
            <div class="input-group">
                <label for="username">아이디</label>
                <input type="text" id="uId" name="userId" placeholder="가입하신 아이디를 입력해주세요.">
            </div>
            <button type="submit">찾기</button>
        </form>
        <form action="/bbs/login" action="GET">
	        <button>로그인 페이지로 이동</button>
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