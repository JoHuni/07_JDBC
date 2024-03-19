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
        <h2>아이디 찾기</h2>
        <form action="/bbs/findId" method="POST">
            <div class="input-group">
                <label for="username">이름</label>
                <input type="text" id="uName" name="userName" placeholder="이름을 입력해주세요.">
            </div>
            <div class="input-group">
                <label for="phoneNum">전화번호</label>
                <input type="Number" id="phoneNum" name="phoneNumber" placeholder="전화번호를 입력해주세요.">
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