<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>Database Web</title>
</head>
<frameset cols="20%,80%">
	<frameset rows="50%,50%">
		<frame src="<c:url value='/DBlistServlet?method=getDBNameList'/>" name="leftTop"/>
		<frame src="<c:url value='view/tableList.jsp'/>" name="leftBottom"/>
	</frameset>
	<frameset rows="50%,50%">
		<frameset cols="50%,50%">
			<frame src="view/tabledata.jsp" name="topLeft"/>
			<frame src="view/textarea.jsp" name="topRight"/>
		</frameset>
		<frame src="view/console.jsp" name="console"/>
	</frameset>
</frameset>
</html>