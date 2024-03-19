<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 가입 페이지</title>
<link rel="stylesheet" href="/resources/css/signup.css">

</head>
<body>

<div class="container">
    <h2>회원가입</h2>
    <form action="/bbs/signup" method="POST">
        <div class="form-group">
            <label for="username">아이디:</label>
            <input type="text" id="username" name="userId"  maxlength=20 required>
        </div>
        <div class="form-group">
            <label for="password">비밀번호:</label>
            <input type="password" id="password" name="userPw"  maxlength=20  required>
        </div>
        <div class="form-group">
            <label for="name">이름:</label>
            <input type="text" id="name" name="userName"  maxlength=10 required>
        </div>
        <div class="form-group">
            <label for="phone">전화번호:</label>
            <input type="text" id="phone" name="phoneNumber"  maxlength=20 required>
        </div>
        <input type="hidden" id="user_grade_no" name="userGradeNo">
        <div class="form-group">
            <button type="submit">가입하기</button>
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