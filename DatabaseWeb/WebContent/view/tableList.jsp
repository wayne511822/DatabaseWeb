<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base target="topLeft"/>
</head>
<body>
	
	<h2>資料表列<hr>${sessionScope.databaseName}<hr></h2>
	<c:forEach items="${tableList}" var="tableList">
		<a href="<c:url value='/DBlistServlet?method=showTableData&tableName=${tableList.dataName}'/>">
		${tableList.dataName}
		</a><br/>
	</c:forEach>
</body>
</html>