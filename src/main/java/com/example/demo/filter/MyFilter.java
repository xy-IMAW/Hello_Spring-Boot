/**
 * 
 */
package com.example.demo.filter;

import java.io.IOException;


import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * @author 谢意
 *
 */
//@WebFilter(filterName="myFilter",urlPatterns="/*")
public class MyFilter implements Filter {
	

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		System.out.println("过滤器销毁");
		
	}


	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO 自动生成的方法存根

		
		System.out.println("过滤器执行操作");
		chain.doFilter(request, response);
	}

	

	@Override
	public void init(FilterConfig config) throws ServletException {
		// TODO 自动生成的方法存根
		System.out.println("过滤器初始化");
	}

}
