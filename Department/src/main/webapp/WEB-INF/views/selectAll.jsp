<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전체 부서 조회</title>
</head>
<body>
	<h1>전체 부서 조회</h1>
	<table border="1">
		
		<thead>
			<tr>
				<th>행 번호</th>
				<th>부서 코드(DEPD_ID)</th>
				<th>부서명(DEPD_TITLE)</th>
				<th>지역 코드(LOCATION_ID)</th>
			</tr>
		</thead>
		
		<tbody>
			<c:forEach items="${deptList}" var="dept" varStatus="vs">
				<tr>
					<%-- vs.count : 현재 반복 횟수 (1부터 시작) --%>
					<td>${vs.count}</td>
					<td>${dept.deptId}</td>
					<td>${dept.deptTitle}</td>
					<td>${dept.locationId}</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
</body>
</html>