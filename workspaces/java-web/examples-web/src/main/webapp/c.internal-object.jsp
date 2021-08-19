<%@page import="java.util.Date"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Internal Object</title>
</head>
<body>

	<h3><% out.println(new Date()); %></h3>

	<% 
	pageContext.setAttribute("data", "pageContext 객체에 저장된 데이터");
	request.setAttribute("data", "request 객체에 저장된 데이터");
	session.setAttribute("data", "session 객체에 저장된 데이터");
	application.setAttribute("data", "application 객체에 저장된 데이터");
	%>
	
	<h3><%= pageContext.getAttribute("data") %></h3>
	<h3><%= request.getAttribute("data") %></h3>
	<h3><%= session.getAttribute("data") %></h3>
	<h3><%= application.getAttribute("data") %></h3>

</body>
</html>