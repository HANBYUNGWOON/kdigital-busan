<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
		 pageEncoding="utf-8"%> 
		 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title></title>
	<link rel="Stylesheet" href="/spring-demoweb/resources/styles/default.css" />
	<style>
	a { text-decoration: none }
	/* 645 ball */
	.ball_645 {display:inline-block; border-radius:100%; text-align:center; vertical-align:middle; color:#fff; font-weight:500; /* text-shadow: 0px 0px 2px rgba(0, 0, 0, 1); */}
	.ball_645.lrg {width:60px; height:60px; line-height:56px; font-size:28px}
	.ball_645.sml {width:24px; height:24px; line-height:22px; font-size:13px}
	.ball_645.not {color:#777}
	.ball_645.sml.not {font-weight:300}
	.ball_645.ball1 {background:#fbc400; text-shadow: 0px 0px 3px rgba(73, 57, 0, .8)}
	.ball_645.ball2 {background:#69c8f2; text-shadow: 0px 0px 3px rgba(0, 49, 70, .8)}
	.ball_645.ball3 {background:#ff7272; text-shadow: 0px 0px 3px rgba(64, 0, 0, .8)}
	.ball_645.ball4 {background:#aaa; text-shadow: 0px 0px 3px rgba(61, 61, 61, .8)}
	.ball_645.ball5 {background:#b0d840; text-shadow: 0px 0px 3px rgba(41, 56, 0, .8)}
	table tr td .ball_645.sml {margin:0 3px}

	/* 720 ball */
	.ball_645.ball6 {background:#c7c7c7; text-shadow: 0px 0px 3px rgba(73, 57, 0, .8)}
	.ball_645.ball7 {background:#ff4c4c; text-shadow: 0px 0px 3px rgba(0, 49, 70, .8)}
	.ball_645.ball8 {background:#ff8e4f; text-shadow: 0px 0px 3px rgba(64, 0, 0, .8)}
	.ball_645.ball9 {background:#fcd153; text-shadow: 0px 0px 3px rgba(61, 61, 61, .8)}
	.ball_645.ball10 {background:#3cbcff; text-shadow: 0px 0px 3px rgba(41, 56, 0, .8)}
	.ball_645.ball11 {background:#8d70da; text-shadow: 0px 0px 3px rgba(41, 56, 0, .8)}
	.ball_645.ball12 {background:#777777; text-shadow: 0px 0px 3px rgba(41, 56, 0, .8)}
	</style>
</head>
<body>

	<div id="pageContainer">	
	
		<jsp:include page="/WEB-INF/views/modules/header.jsp" />
		
		<div style="padding-top:25px;text-align:center">
			<form action="stats-by-section.action" method="post">
			<table border="1" style="width:800px;margin:0 auto">
				<tr style="height:30px">
					<th style="width:20%">범위</th>
					<td style="text-align:left">
						<select name="range">
							<option value="5" ${ range eq 5 ? "selected" : "" }>5번대</option>
							<option value="10" ${ range eq 10 ? "selected" : "" }>10번대</option>
						</select>						
					</td>
				</tr>
				<tr style="height:30px">
					<th>기간</th>
					<td style="text-align:left">
						<select name="weeks">
							<option value="5" ${ weeks eq 5 ? "selected" : "" }>최근 5주</option>
							<option value="10" ${ weeks eq 10 ? "selected" : "" }>최근 10주</option>
							<option value="15" ${ weeks eq 15 ? "selected" : "" }>최근 15주</option>
						</select>
					</td>
				</tr>
				<tr>					
					<td colspan="2" style="text-align: center;height:50px">
						<input type="submit" value="조회"><!-- type=submit : 포함된 form을 서버로 submit -->
					</td>
				</tr>
			</table>
			</form>
			<br><br>
			
			<c:set var="max" value="0" />
			<c:forEach var="count" items="${ countBySection }">
				<c:if test="${ max < count }">
					<c:set var="max" value="${ count }" />
				</c:if>
			</c:forEach>
			<c:set var="colors" value='${ fn:split("#fbc400,#69c8f2,#ff7272,#aaa,#b0d840", ",") }' />
			
			<table border="1" style="width:800px;margin:0 auto">
				<tr style="background-color:#f5f5f5;height:40px">
					<th style="width:80px">번호대</th>
					<th>그래프</th>
					<th style="width:80px">당첨횟수</th>
				</tr>
				<c:forEach var="count" items="${ countBySection }" varStatus="status">
				<tr style="height:40px">
					<td style="text-align:center">
						${ status.index * range + 1 } ~ ${ (status.index + 1) * range } 번대
					</td>
					<td>
						<fmt:parseNumber var="color" integerOnly="true" value="${ (status.index / (10 / range)) }" />
						<div style="background-color:${ colors[color] };width:${ (count / max) * 100 }%;">&nbsp;</div>
					</td>
					<td style="text-align:center">${ count }</td>
				</tr>
				</c:forEach>
								
			</table>
			<br /><br /><br /><br />
		
		</div>
		
	</div>
		

</body>
</html>