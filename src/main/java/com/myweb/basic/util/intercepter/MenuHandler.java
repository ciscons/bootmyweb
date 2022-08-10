package com.myweb.basic.util.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MenuHandler implements HandlerInterceptor{

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

//		System.out.println("메뉴포스트핸들러 실행");
		System.out.println("포스트핸들러 MENU:" + request.getRequestURI());
		request.setAttribute("menu", request.getRequestURI());
	}

	
	
}
