/**
 * 
 */
package com.example.demo.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * @author 谢意
 *只有通过DispatcherServlet访问才能调用httpsessionlistener
 */
//@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent arg0) {
		// TODO 自动生成的方法存根
		System.out.println("session创建");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO 自动生成的方法存根
		System.out.println("session销毁");
	}

}
