<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>tableList</title>
		<base target="topLeft"/>
	
		<style type="text/css">
			* {
				margin: 0px;
				background-color: #E0E0E0;
			}
			body {
				font-family: Arial,sans-serif;
			}
			div {
				width: 90%;
				height: 50px;
				line-height:50px;
				margin-bottom: 10px;
				font-size: 30px;
				font-weight: bold;
				color: white;
				padding-left: 10px;
				background-color: #6C6C6C;
			}
			h3 {
				height: 5px;
				margin: 15px;
				line-height: 5px;
			}
			a {
				height: 5px;
				margin: 15px;
				text-decoration: none;
			}
			a:link, a:visited {
			 	color: black;
			}
			a:hover {
				color: #4CAF50
			}
			a:active {
				color: black;
			}
		</style>
	</head>
	<body>
		
		<div>Table List</div>
		<h3>${sessionScope.databaseName}</h3>
		
		<c:forEach items="${tableList}" var="tableList">
			<a href="<c:url value='/DBlistServlet?method=showTableData&tableName=${tableList.dataName}'/>">
			${tableList.dataName}
			</a><br/>
		</c:forEach>
	</body>
</html>