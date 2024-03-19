<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
</head>
    <div class="container">
        <h1>자유게시판</h1>
        <div class="board">
      	 	<c:forEach items="${BBSList}" var="bbs">
			   <div class="post">
		          <p>${bbs.boardNo}</p>
			   	  <h3>작성자 : ${bbs.writer}</h3>
		          <h2>${bbs.title}</h2>
		          <p>${bbs.content}</p>
					<c:choose>
					    <c:when test="${not empty loginUser and loginUser.userId eq bbs.writer and loginUser.userId ne 'hune0198'}">
                            <form action="/bbs/deleteBbs" method="GET">
                                <input type="hidden" name="boardNo" value="${bbs.boardNo}">
                                    <div style="text-align: right;">
                                        <button id="deleteBtn">삭제</button>
                                        <button id="updateBtn">수정</button>
                                    </div>
                            </form>
					    </c:when>
					</c:choose>
					<c:choose>
					    <c:when test="${not empty loginUser and loginUser.userId eq 'hune0198'}">
                            <form action="/bbs/deleteBbs" method="GET">
                                <input type="hidden" name="boardNo" value="${bbs.boardNo}">
                                    <div style="text-align: right;">
                                        <button id="deleteBtn">삭제</button>
                                    </div>
                            </form>
                            <form action="/bbs/updateBbs" method="GET">
								<button id="updateBtn">수정</button>
                            </form>
					    </c:when>
					</c:choose>
		       </div>
     		</c:forEach>
        </div>
        <c:choose>
            <c:when test="${empty loginUser}">
                <form action="/bbs/login" method="GET">
                    <button>로그인</button>
                </form>
                <form action="/bbs/signup" method="GET">
                    <button>회원가입</button>
                </form>
                <div class="findUser">
                    <form action="/bbs/findId" method="GET">
                    	<button>아이디 찾기</button>
                    </form>
                    <form action="/bbs/findPw" method="GET">
                    	<button>비밀번호 찾기</button>
                    </form>
                </div>
            </c:when>
            <c:otherwise>
                <form action="/bbs/logout" method="POST">
                    <button id="logoutBtn">로그아웃</button>
                </form>
                <form action="/bbs/update" method="GET">
                    <button id="logoutBtn">정보 수정</button>
                </form>
            </c:otherwise>
        </c:choose>
        <c:choose>
            <c:when test="${not empty loginUser}">
                <div class="findUser">
    		        <form action="/bbs/write" method="GET">
    		            <button id="postBtn">글쓰기</button>
    		        </form>  
                </div>
            </c:when>
        </c:choose>
    </div>
    <c:if test="${not empty message}" >
        <script>
            alert("${message}");
        </script>
        <c:remove var="message" />
    </c:if>
</body>
</html>
