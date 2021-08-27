package com.demoweb.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DemoWebListener implements ServletContextListener, HttpSessionListener {

    public void contextInitialized(ServletContextEvent sce)  {
    	ServletContext application = sce.getServletContext(); // JSP의 application 내장 객체와 같은 객체
    	application.setAttribute("total", 0);
    	application.setAttribute("current", 0);    	
    }
    public void sessionCreated(HttpSessionEvent se)  { 
    	ServletContext application = se.getSession().getServletContext(); // JSP의 application 내장 객체와 같은 객체
    	int total = (int)application.getAttribute("total") + 1;
    	application.setAttribute("total", total);
    	int current = (int)application.getAttribute("current") + 1;
    	application.setAttribute("current", current);
    }
    public void sessionDestroyed(HttpSessionEvent se)  {
    	ServletContext application = se.getSession().getServletContext(); // JSP의 application 내장 객체와 같은 객체
    	int current = (int)application.getAttribute("current") - 1;
    	application.setAttribute("current", current);
    }
    public void contextDestroyed(ServletContextEvent sce)  {
    }

	
}
