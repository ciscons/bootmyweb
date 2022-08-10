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
		
		//어플리케이션 개발 단게에서는 주석으로 처리하고, 최종 테스트하는 과정에서 사용한다.
//		HttpSession session = request.getSession();
//		String userId = (String)session.getAttribute("userId"); //string 또는 vo 같은 객체가 될 수도 있다.
		//나중에 세션을 사용할 때 userId라는 키로 사용하겠다는 말이고, 화면단에서 session.userId로 접근할 수 있다. 이걸 안맞추면 협업이 힘들어진다.
		
//		if(userId == null) {
//			//redirect는 절대 2 번 있을 수 없다.
//			response.sendRedirect(request.getContextPath() + "/user/login"); //로그인페이지로 redirect 순수한 java code로 redirect하는 방법이다.
//			return false;
//		} else {
//			
//			return true;
//		}
		//처음에 등록? -> 서버 리로드 될떄마다 계속 로그인
		//로그인이 성공했을때 userId라는 이름으로 유저의 아이디를 저장한다고 가정.
		//인터셉터에서 userId가 null이라면 return false로 접근하지 못하도록 처리해주세요
		//인터셉터의 등록은 product경로로 시작하는 모든곳에 적용하고 login는 제외
		
		//임시 방편이다. (세션을 사용한 테스트를 하기 위함임)
		HttpSession session = request.getSession();
		session.setAttribute("userId" , "admin");
		String userId = (String)session.getAttribute("userId");
		return true;
	}

	
}
