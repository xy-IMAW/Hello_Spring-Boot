/**
 * 
 */
package com.example.demo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * @author 谢意
 *
 */
//@WebListener
public class MyListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO 自动生成的方法存根
		System.out.println("servletcontext销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		// TODO 自动生成的方法存根
		System.out.println("servletcontext初始化");
		System.out.println(sce.getServletContext().getServerInfo());
	}

}
