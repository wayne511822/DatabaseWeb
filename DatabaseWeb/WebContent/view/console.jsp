<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		
		div {
			color: red;
			size: 10px;
			font: bold;
			
		}
	</style>
</head>
<body>
	正在操作:[${sessionScope.databaseName}]
	<div>${sessionScope.error}</div><p/>
	
	<table>
		<c:forEach items="${queryList }" var="rlist">
		<tr>
			<c:forEach items="${rlist }" var="clist">
			<td>
			${clist}
			</td>
			</c:forEach>	
		</tr>
		</c:forEach>
	</table>
</body>


</html>