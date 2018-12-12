package com.imooc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.imooc.pojo.User;
/**
 * 自定义拦截器类
 * @author Administrator
 *
 */
public class MyInterceptor implements HandlerInterceptor {

	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("afterCompletion...");

	}

	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
	System.out.println("postHandle...");

	}

	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
	/*	System.out.println("preHandle...");
		User user=(User) arg0.getSession().getAttribute("existUser");
		 if (user!=null) {
			return true;
		}
		return false;*/
		return true;
	}

}
