<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>비밀번호 찾기 결과</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/login.css">
</head>
<body>
    <div class="login-container">
        <h2>비밀번호 찾기 결과</h2>
            <div class="input-group">
                <label for="userPw">아이디 : ${user.userPw}</label>
            </div>
        <form action="/view/login.jsp">
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