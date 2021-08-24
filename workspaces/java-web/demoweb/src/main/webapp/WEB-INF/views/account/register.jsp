<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>사용자등록</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input.css" />

</head>
<body>

	<div id="pageContainer">

		<jsp:include page="/WEB-INF/views/modules/header.jsp" />	
	
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">회원기본정보</div>

		        <form id="registerform" 
		        	  action="register.action" method="post"><!-- 상대경로표시 -->
		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <input type="text" id="memberId" name="memberId" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" id="passwd" name="passwd" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호 확인</th>
		                <td>
		                    <input type="password" id="confirm" name="confirm" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>이메일</th>
		                <td>
		                	<input type="text" id="email" name="email" style="width:280px" />
		                </td>
		            </tr>
		                       		            
		        </table>
		        <div class="buttons">
		        	<input id="register" type="button" value="등록" style="height:25px" />
		        	<input id="cancel" type="button" value="취소" style="height:25px"  />

		        </div>
		        </form>
		    </div>
		</div>   	
	
	</div>
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	<script type="text/javascript">
	$(function() {
		
		$('#cancel').on('click', function(event) {
			location.href = "/demoweb/home.action";
		});
		
		$('#register').on('click', function(event) {
			
			/* 
			var memberId = $('#memberId').val();
			if (memberId.length < 6 || memberId.length > 12) {
				alert('아이디 형식 오류 (6 ~ 12개의 영문자 또는 숫자)');
				return;
			} 
			*/
			
			// 문자열의 형식을 분석, 검증하는 도구 -> 정규 표현식 (regular expression)
			var re = /^[A-Za-z0-9]{6,12}$/;
			var memberId = $('#memberId').val();
			if ( !re.test(memberId) ) {
				alert('아이디 형식 오류 (6 ~ 12개의 영문자 또는 숫자)')
				return;
			}
			
			re = /[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]$/i;
			var email = $('#email').val();
			if ( !re.test(email) ) {
				alert('이메일 형식 오류');
				return;
			}
			
			$('#registerform').submit(); // form을 서버로 전송
			
		});
	});
	</script>

</body>
</html>














