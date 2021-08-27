<%@ page import="com.demoweb.vo.MemberVO" %>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>
    	 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

		<%-- 
		<c:if test="${ empty param.bgcolor }">
		<div id='header'>
		</c:if>
		<c:if test="${ not empty param.bgcolor }">
		<div id='header' style='background-color:${ param.bgcolor }'>
		</c:if> 
		--%>
		
		<c:choose>
		<c:when test="${ empty param.bgcolor }">
		<div id='header'>
		</c:when>
		<c:otherwise>
		<div id='header' style='background-color:${ param.bgcolor }'>
		</c:otherwise>
		</c:choose>
		
            <div class="title">
                <a href="/demoweb/home.action">DEMO WEBSITE</a>
            </div>
            <div class="links">
            <c:choose>
            <c:when test="${ empty loginuser }">
            	<a href="/demoweb/account/login.action">로그인</a>
                <a href="/demoweb/account/register.action">회원가입</a>
            </c:when>
            <c:otherwise>
                ${ loginuser.memberId }님 환영합니다.
                <a href="/demoweb/account/logout.action">로그아웃</a>
            </c:otherwise>
            </c:choose>
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
                    <li><a href="/demoweb/lotto/init-data.action">데이터초기화</a></li>
					<li><a href="/demoweb/lotto/stats-by-number.action">번호별통계</a></li>
					<li><a href="/demoweb/lotto/stats-by-section.action">구간별통계</a></li>
                </ul>
            </div>
		</div>
		
		<div id="counter" style="text-align:right;padding: 5px;margin-top:1px;border:solid 1px black">
			[TOTAL : ${ applicationScope.total }][CURRENT : ${ applicationScope.current }]
		</div>
		
		
		
		