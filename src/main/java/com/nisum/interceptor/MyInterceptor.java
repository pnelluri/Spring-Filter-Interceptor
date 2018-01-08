package com.nisum.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nisum.model.Person;

@Component
public class MyInterceptor extends HandlerInterceptorAdapter {

	
	@Override
	public boolean preHandle(HttpServletRequest request, 
			HttpServletResponse response, Object object) throws Exception {
		System.out.println("In preHandle we are Intercepting the Request");
		String requestURI = request.getRequestURI();
		Integer personId = ServletRequestUtils.getIntParameter(request, "personId", 0);
		System.out.println("Pre handle Interceptor::" + requestURI + 
				" || Search for Person with personId ::" + personId);
		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, 
			Object object, ModelAndView model)
			throws Exception {
		
		System.out.println("In postHandle request processing "
				+ "completed by @RestController");
long startTime = (Long)request.getAttribute("startTime");
		
		long endTime = System.currentTimeMillis();

		long executeTime = endTime - startTime;
		
		model.addObject("executeTime",executeTime);

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, 
			Object object, Exception arg3)
			throws Exception {
		System.out.println("In afterCompletion Request Completed");
	}
}
