<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
		 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lotto</title>
</head>
<body>
<%
int[] numbers = new int[6];
for (int i = 0; i < numbers.length; i++) {
	numbers[i] = (int)(Math.random() * 45) + 1; // 1 ~ 45
}
%>

	<table border="1" align="center">
		<tr>
			<% for (int number : numbers) { %>
			<th style="width:50px; height:50px"><%= number %></th>
			<% } %>
		</tr>
	</table>

</body>
</html>