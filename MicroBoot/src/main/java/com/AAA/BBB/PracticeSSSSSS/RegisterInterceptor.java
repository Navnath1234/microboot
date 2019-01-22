package com.AAA.BBB.PracticeSSSSSS;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class RegisterInterceptor implements WebMvcConfigurer {
	
	@Autowired
	InterceptorImpl interceptorImpl;

	   @Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      registry.addInterceptor(interceptorImpl);
	   }
	

}
