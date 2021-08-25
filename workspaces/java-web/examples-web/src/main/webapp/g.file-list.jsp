<%@page import="java.util.Date"%>
<%@page import="java.io.File"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
    	 pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>

	<h3>
		<a href="g.file-upload-form.jsp">파일 업로드</a>
	</h3>
	<hr>
	<%-- 1. 업로드 파일 저장소(폴더)에서 파일 목록 읽기 --%>
	<% 
	String path = application.getRealPath("/upload-files");
	File file = new File(path);
	File[] files = file.listFiles(); // 디렉터리에 포함된 모든 파일과 디렉터리를 File형식의 배열로 반환
	%>

	<%-- 2. 파일 목록 표시 --%>	
	<% if (files.length == 0) { %>
		<h3>업로드된 파일이 없습니다.</h3>
	<% } else { %>
		<h3>업로드 파일 목록</h3>
	<% } %>

	<table width="700" border="1">
		<tr>
			<th>파일이름</th>
			<th>파일크기</th>
			<th>마지막 수정 시간</th>
		</tr>
	<% for (File f : files) { %>
		<tr>
			<td>
				<%= f.getName() %>
				&nbsp;
				[<a href="download?file=<%= f.getName() %>">다운로드</a>]
			</td>
			<td><%= f.length() %></td>
			<td><%= new Date(f.lastModified()) %></td>
		</tr>
	<% } %>
	</table>

</body>
</html>











