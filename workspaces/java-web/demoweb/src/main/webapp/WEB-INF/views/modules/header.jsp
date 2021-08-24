<%@ page import="com.demoweb.vo.MemberVO" %>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8"%>

		<% String bgColor = request.getParameter("bgcolor"); %>
		
		<% if (bgColor == null) { %>
		<div id='header'>
		<% } else { %>
		<div id='header' style='background-color:<%= bgColor %>'>
		<% } %>
            <div class="title">
                <a href="/demoweb/home.action">DEMO WEBSITE</a>
            </div>
            <div class="links">
            <% MemberVO member = (MemberVO)session.getAttribute("loginuser"); %>
            <% if (member == null) { // 로그인하지 않은 경우 %>
            	<a href="/demoweb/account/login.action">로그인</a>
                <a href="/demoweb/account/register.action">회원가입</a>
            <% } else { //로그인한 경우 %>
                <%= member.getMemberId() %>님 환영합니다.
                <a href="/demoweb/account/logout.action">로그아웃</a>
            <% } %>
            </div>
        </div>
                
        <div id="menu">
            <div>
                <ul>
                    <li><a href="#">사용자관리</a></li>
					<li><a href="#">메일보내기</a></li>
					<li><a href="#">자료실</a></li>
					<li><a href="#">게시판</a></li>
                </ul>
            </div>
		</div>