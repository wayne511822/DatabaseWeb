<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base target="console" />
<title>textarea</title>
	<style type="text/css">
		* {
			margin: 0px;
			background-color: #E0E0E0;
		}
		body {
			font-family: Arial,sans-serif
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
		.btn {
			background-color: white;
			font-weight: bold;
			
		}
		.down {
			background-color: #BEBEBE;
			font-weight: bold;
			
		}
	</style>
</head>
<body>

<form id="form" action="${pageContext.request.contextPath}/DBlistServlet" method="get" style="">
	<input hidden="true" name="method" value="sqlCommands" />
	<div>SQL commands panel</div>
	<input class="btn" onMouseDown="this.className='down'" onMouseUp="this.className='btn'" id="btn" type="submit" value="Execute" /><br>

	<textarea name="scp" rows="16" cols="70" onscroll="this.cols++;"></textarea>
	
</form>

</body>

<script type="text/javascript">
	
</script>

</html>