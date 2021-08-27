package com.demoweb.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class DemoWebListener implements ServletContextListener, HttpSessionListener {

    public void contextInitialized(ServletContextEvent sce)  {
    	System.out.println("DemoWeb Application Started");
    }
    public void sessionCreated(HttpSessionEvent se)  { 
    	System.out.println("Session Started");
    }
    public void sessionDestroyed(HttpSessionEvent se)  { 
    	System.out.println("Session Finished");
    }
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("DemoWeb Application Finished");
    }

	
}
