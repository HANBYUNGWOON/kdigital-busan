<%@ page language="java" 
		 contentType="text/html; charset=utf-8" 
		 pageEncoding="utf-8"%>

<%

pageContext.setAttribute("page-data", "This is Page Scope Data (from forward)");
request.setAttribute("req-data", "This is Request Scope Data (from forward)");

//JSP에서 사용할 수 있는 구문	
//pageContext.forward("d.result.jsp");

//JSP와 Servlet에서 사용할 수 있는 구문
RequestDispatcher dispatcher = request.getRequestDispatcher("d.result.jsp");
dispatcher.forward(request, response);	// forward 방식으로 d.result.jsp로 이동

%>