<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<style type="text/css">
		table, tr, th, td {
			border-collapse: collapse;
			border: 2px solid black;
			padding: 4px;
		}
	
	</style>
</head>
<body>
	${sessionScope.databaseName } --> ${sessionScope.tableName }
	
	<table>
		<c:forEach items="${tableDataList }" var="DataList">
		<tr>
			<c:forEach items="${DataList }" var="data">
			<td>
			${data}
			</td>
			</c:forEach>	
		</tr>
		</c:forEach>
	</table>
</body>
</html>