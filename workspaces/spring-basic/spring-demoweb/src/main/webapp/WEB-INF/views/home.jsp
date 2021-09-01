<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset='utf-8' />
	<title>Home</title>
	<link rel='Stylesheet' href='/spring-demoweb/resources/styles/default.css' />
</head>
<body>

	<div id='pageContainer'>
		<jsp:include page="/WEB-INF/views/modules/header.jsp">
			<jsp:param name="bgcolor" value="palegreen" />
			<jsp:param name="a" value="v" />
		</jsp:include>		
		
		<div id='content'>
			<br /><br /><br />
			<h2 style='text-align:center'>Welcome to Demo WebSite !!!</h2>
		</div>
	</div>

</body>
</html>


