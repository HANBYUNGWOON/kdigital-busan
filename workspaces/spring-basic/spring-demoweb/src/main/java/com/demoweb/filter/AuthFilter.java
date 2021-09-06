package com.demoweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demoweb.vo.MemberVO;

//@WebFilter(urlPatterns = { "*.action" }) // AuthInterceptor로 대체
public class AuthFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)arg0;
		HttpServletResponse resp = (HttpServletResponse)arg1;
		HttpSession session = req.getSession();
		
		String uri = req.getRequestURI(); // 현재 요청의 전체 경로 문자열
		
		//로그인 한 사용자인 경우 세션 객체에 loginuser 라는 이름으로 데이터가 저장되어 있으므로 데이터 읽어 오기
		MemberVO member = (MemberVO)session.getAttribute("loginuser");
		
		boolean invalid = false;
		if (uri.contains("/lotto/")) { // 경로에 /lotto/ 가 포함된 경우
			if (member == null) { // 로그인 하지 않은 경우
				invalid = true;
			} else if (uri.contains("init-data.action") && 
					   !member.getUserType().equals("admin")) { // 경로에 init-data.action이 포함되고 admin이 아닌 경우
				invalid = true;
			}
		}
		if (invalid) {
			resp.sendRedirect("/spring-demoweb/account/login.action");
			return;
		}
		arg2.doFilter(arg0, arg1);
	}

}
