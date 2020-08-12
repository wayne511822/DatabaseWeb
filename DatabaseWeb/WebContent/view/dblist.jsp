<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<base target="leftBottom">
	<meta charset="UTF-8">
</head>
<body>
	<h2>Database List</h2>
	<c:forEach items="${dbNameList}" var="dbName">
		<a href="<c:url value='/DBlistServlet?method=getTableNameList&name=${dbName.dataName}'/>">${dbName.dataName}</a><br/>
	</c:forEach>
	
	
</body>
</html>