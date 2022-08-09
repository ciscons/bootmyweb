package com.myweb.basic.util.intercepter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class UserAuthHandler implements HandlerInterceptor {
	
	
	//회원 관련 요청이 들어왔을때 가로채서 처리할 인터셉터
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("유저인터셉터 실행됨");
		HttpSession session = request.getSession();
		session.getAttribute("userId");
		
		if(userId == null) {
			
			return false;
		} else {
			
			return true;
		}
		//처음에 등록? -> 서버 리로드 될떄마다 계속 로그인
		//로그인이 성공했을때 userId라는 이름으로 유저의 아이디를 저장한다고 가정.
		//인터셉터에서 userId가 null이라면 return false로 접근하지 못하도록 처리해주세요
		//인터셉터의 등록은 product경로로 시작하는 모든곳에 적용하고 login는 제외
		
		
		return true; //컨트롤러를 실행함
	}

	
}