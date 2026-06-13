package com.nt.interceptors;

import java.time.LocalDateTime;

import org.jspecify.annotations.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class TimeCheckInterceptors implements  HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler)
			throws Exception {
        System.out.println("TimeCheckInterceptors.preHandle()");
    if(!req.getServletPath().equals("/")) {   
        //get System Date and time
        LocalDateTime  ldt=LocalDateTime.now();
        // get current hour of the day
        int  hour=ldt.getHour();
        if(hour<9  || hour>=17  ) {
        	RequestDispatcher  rd=req.getRequestDispatcher("/timeout.jsp");
        	rd.forward(req, res);
        	return false;
        }
    }
        return true;
   }
}
