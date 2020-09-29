<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<base target="leftBottom">
		<meta charset="UTF-8">
		<title>dblist</title>
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
			a {
				height: 5px;
				margin: 15px;
				text-decoration: none;
			}
				a:link, a:visited {
				 	color: black;
			}
			a:hover {
				color: #4CAF50;
			}
			a:active {
				color: black;
			}
		</style>
	</head>
	<body>
		<div>Database List</div>
		
		<c:forEach items="${dbNameList}" var="dbName">
			<a href="<c:url value='/DBlistServlet?method=getTableNameList&name=${dbName.dataName}'/>">${dbName.dataName}</a><br/>
		</c:forEach>
	</body>
</html>