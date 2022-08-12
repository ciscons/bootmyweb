package com.myweb.basic.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.myweb.basic.util.intercepter.MenuHandler;
import com.myweb.basic.util.intercepter.UserAuthHandler;

@Configuration //스프링부트의 빈 생성 클래스
public class WebConfig implements WebMvcConfigurer {

	//인터셉터 등록
	@Bean
	public UserAuthHandler userAuthHandler() {
		return new UserAuthHandler();
	}

	@Bean
	public MenuHandler menuHandler() {
		return new MenuHandler();
	}
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor( userAuthHandler() )
				.addPathPatterns("/product/**")
				.addPathPatterns("/topic/**")
				.addPathPatterns("/user/**")
				.addPathPatterns("/notice/**")
				.addPathPatterns("/main")
				.excludePathPatterns("/user/login");
		
		//메뉴 고정하는 부분
		registry.addInterceptor( menuHandler() )
				.addPathPatterns("/product/**")
				.addPathPatterns("/notice/**")
				.addPathPatterns("/user/**");
		
	}
}
