package com.nil.interceptor;

import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class StudentFormInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		HttpSession ses=null;
		int cToken=0;
		int sToken=0;
		RequestDispatcher rd=null;
		System.out.println("LoginInterceptor.preHandle()");
		//create session object
		ses=request.getSession();
		if(request.getMethod().equalsIgnoreCase("GET")) {
			ses.setAttribute("sToken", new Random().nextInt(1000));
			return true;
		}else {
			cToken=Integer.parseInt(request.getParameter("cToken"));
			sToken=(int) ses.getAttribute("sToken");
			if(cToken==sToken) {
				ses.setAttribute("sToken",new Random().nextInt(1000));
				return true;
			}else {
				rd=request.getRequestDispatcher("/error.jsp");
				rd.forward(request, response);
				return false;
			}
			
		}

	}
}
