<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>console</title>
		<style type="text/css">
			* {
				margin: 0px;
			}
			body {
				font-family: Arial,sans-serif;
			}
			div {
				width: 100%;
				height: 30px;
				line-height:30px;
				margin-bottom: 10px;
				font-size: 20px;
				font-weight: bold;
				color: black;
				padding-left: 10px;
				background-color: #E0E0E0;
			}
			p {
				width: 60%;
				margin-left: 10px;
				margin-bottom: 10px;
				padding: 5px;
				font-weight: bold;
				color: red;
				padding-left: 10px;
			}
			table, tr, th, td {
				border-collapse: collapse;
				border: 2px solid black;
				margin-left:15px;
				padding: 4px;
			}
		</style>
	</head>
	<body>
		<div>正在操作資料庫:[${sessionScope.databaseName}]</div>
		<p>${sessionScope.error}</p>
		
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