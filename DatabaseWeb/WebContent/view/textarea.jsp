<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base target="console" />

<style type="text/css">
		* {
	  box-sizing: border-box;
	}
	
	body {
	  margin: 0;
	}
	
</style>
</head>
<body>

<form id="form" action="${pageContext.request.contextPath}/DBlistServlet" method="get" style="">
	<input hidden="true" name="method" value="sqlCommands" />
	&emsp;SQL commands panel&emsp;&emsp;正在操作:[${sessionScope.databaseName}]
	<input id="btn" type="submit" value="Execute" />

	<textarea name="scp" rows="16" cols="70" onscroll="this.cols++;"></textarea>
	
</form>

</body>

<script type="text/javascript">
	
</script>

</html>