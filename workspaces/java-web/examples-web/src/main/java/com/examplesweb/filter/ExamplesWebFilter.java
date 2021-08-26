package com.examplesweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ExamplesWebFilter implements Filter {

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest req = (HttpServletRequest)arg0;
		String url = req.getRequestURI();
		System.out.println(url);
		
		if (url.contains("a")) {
			HttpServletResponse resp = (HttpServletResponse)arg1;
			resp.sendRedirect("index.html");
			return;
		}
		
		arg2.doFilter(arg0, arg1); // 다음 처리기로 이동 (다른 Filter or Servlet or JSP or ...)
		
	}

}
