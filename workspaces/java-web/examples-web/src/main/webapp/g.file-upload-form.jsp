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
		<a href="g.file-list.jsp">목록보기</a>
	</h3>
	<hr>
	<h3>파일 업로드 테스트</h3>

	<form action="file-upload" 
		  method="post" 
		  enctype="multipart/form-data">
		  
		FORM DATA : <input type="text" name="formdata">
		<br><br>
		  
		FILE DATA : <input type="file" name="myfile">
		<br><br>
		
		<input type="submit" value="파일 전송">
		
	</form>

</body>
</html>