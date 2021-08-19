<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Structure</title>
</head>
<body>

<%-- <%! : 선언문 : 클래스의 멤버 메서드, 멤버 변수를 선언하는 영역 --%>
<%!
String getCurrentTimeString() {
	return new Date().toString();
}
%>

<%-- 이 영역은 JSP 주석입니다 : JSP 해석기가 무시하는 (해석하지 않는) 영역  --%>
<!-- 이 영역은 HTML 주석입니다 : 브라우저가 무시하는 영역 / JSP 해석기는 문자열로 처리 -->

<%	
	// 자바 문법이 적용되는 영역
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
	out.println("<h3>" + sdf.format(new Date()) + "</h3>");
%>

<%-- <%= : 표현식(expression) : 출력구문을 자동으로 생성, =이 out.print 역할 수행 --%>
<h3><%= sdf.format(new Date())  %></h3>

<h3><%= getCurrentTimeString()  %></h3>

</body>
</html>