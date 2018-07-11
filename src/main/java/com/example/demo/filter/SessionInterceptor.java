/**
 * 
 */
package com.example.demo.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author 谢意
 *
 */
public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
		System.out.println(request.getRequestURI());
		//登录不拦截
		if(request.getRequestURI().equals("/user/login")||request.getRequestURI().equals("/user/login_view")) {
			return true;
		}
		//验证session是否存在
		Object obj = request.getSession().getAttribute("_session_user");
		if(obj == null) {
			response.sendRedirect("/user/login_view");
			return false;
		}
		return true;
	}

}
