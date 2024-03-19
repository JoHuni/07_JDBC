<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시물</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/main.css">
</head>
<body>
    <div class="container">
        <h1>게시물</h1>
        <div class="post">
            <h2><%= request.getParameter("title") %></h2>
            <p><%= request.getParameter("content") %></p>
        </div>
    </div>
</body>
</html>