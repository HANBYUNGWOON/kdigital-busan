package com.demoweb.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.demoweb.vo.MemberVO;

public class AuthInterceptor implements HandlerInterceptor {

	// Controller 호출 전에 호출되는 메서드
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		System.out.println("preHandle");
		
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
			return false; // 현재 요청 처리 중단
		}
		
		return true; // 계속 진행
	}

	// Controller 호출 후에 호출되는 메서드
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("postHandle");
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	// View 처리 후에 호출되는 메서드
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("afterCompletion");
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

}
