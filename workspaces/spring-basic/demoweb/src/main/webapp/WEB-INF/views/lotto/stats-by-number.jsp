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
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
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
			<form action="stats-by-number.action" method="post">
			<table border="1" style="width:800px;margin:0 auto">
				<tr style="height:30px">
					<th style="background-color:#f5f5f5;width:20%">보너스번호</th>
					<td style="text-align:left">
						<select name="includeBno">
							<option value="1" ${ requestScope.includeBno ? "selected" : "" }>포함</option>
							<option value="0" ${ includeBno ? "" : "selected" }>미포함</option>
						</select>			
					</td>
				</tr>
				<tr style="height:30px">
					<th style="background-color:#f5f5f5">회차선택</th>
					<td style="text-align:left">
						<select name="rndFrom">
							<c:forEach var="i" begin="1" end="977">
							<option value="${ i }" ${ i eq requestScope.rndFrom ? "selected" : "" }>${ i }</option>
							</c:forEach>
						</select>
						&nbsp; ~ &nbsp;
						<select name="rndTo">
							<c:forEach var="i" begin="1" end="977">
							<option value="${ i }" ${ i == rndTo ? "selected" : "" }>${ i }</option>
							</c:forEach>
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
			<c:forEach var="count" items="${ countByNumber }">
				<c:if test="${ max < count }">
					<c:set var="max" value="${ count }" />
				</c:if>
			</c:forEach>
			<%-- <c:set var="colors" value='${["#fbc400", "#69c8f2", "#ff7272", "#aaa", "#b0d840"]}' /> --%>
			<c:set var="colors" value='${ fn:split("#fbc400,#69c8f2,#ff7272,#aaa,#b0d840", ",") }' />
			
			<table border="1" style="width:800px;margin:0 auto">
				<tr style="background-color:#f5f5f5;height:40px">
					<th style="width:80px">번호</th>
					<th>그래프</th>
					<th style="width:80px">당첨횟수</th>
				</tr>
				<c:forEach var="count" items="${ countByNumber }" varStatus="status">
				<tr style="height:40px">
					<td style="text-align:center">
						<fmt:parseNumber var="ball_no" integerOnly="true" value="${ (status.index / 10) + 1 }" />
						<span class="ball_645 sml ball${ ball_no }">${ status.index + 1 }</span>
					</td>
					<td>
						<fmt:parseNumber var="color" integerOnly="true" value="${ (status.index / 10) }" />
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