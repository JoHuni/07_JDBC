<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>글수정</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/write.css">
</head>
<body>
    <div class="container">
        <h1>글수정</h1>
        <form action="/bbs/updateBbs" method="POST">
            <label for="title">제목:</label><br>
            <input type="text" id="title" name="title" maxLength=100>${bbs.title}<br>
            <label for="content"></label><br>
            <textarea id="content" name="content">내용:${bbs.content}</textarea><br><br>
            <input type="submit" value="작성">
        </form>
    </div>
</body>
</html>