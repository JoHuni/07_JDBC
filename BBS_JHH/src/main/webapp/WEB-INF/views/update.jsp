<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="/resources/css/signup.css">

</head>
<body>

<div class="container">
    <h2>회원 정보 수정</h2>
    <form action="/bbs/update" method="POST">
        <div class="form-group">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="userId" value="${loginUser.userId}" readonly>
        </div>
        <div class="form-group">
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="userPw"  value="${loginUser.userPw}" required>
        </div>
        <div class="form-group">
            <label for="name">이름:</label>
            <input type="text" id="name" name="userName" value="${loginUser.userName}" required>
        </div>
        <div class="form-group">
            <label for="phone">전화번호:</label>
            <input type="text" id="phone" name="phoneNumber" value="${loginUser.phoneNumber}"required>
        </div>
        <input type="hidden" id="user_grade_no" name="userGradeNo value="default_grade">
        <div class="form-group">
            <button type="submit">수정하기</button>
        </div>
    </form>
    <form action="/bbs/delete" method="GET">
        <div class="form-group">
            <button type="submit">탈퇴하기</button>
        </div>
    </form>
</div>
  <c:if test="${not empty message}" >
    <script>
      alert("${message}");
    </script>

    <c:remove var="message" />
  </c:if>
</body>
</html>