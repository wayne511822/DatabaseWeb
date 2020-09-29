<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>tabledata</title>
		<style type="text/css">
			* {
				margin: 0px;
			}
			body {
				font-family: Arial,sans-serif;
			}
			div {
				width: 95%;
				height: 30px;
				line-height:30px;
				margin-bottom: 10px;
				font-size: 20px;
				font-weight: bold;
				color: black;
				padding-left: 10px;
				background-color: #E0E0E0;
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
		<div>${sessionScope.databaseName } . ${sessionScope.tableName } </div>
		
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