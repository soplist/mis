package com.jingrui.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jingrui.domain.User;

public class LoginFilter implements  Filter{

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest servletRequest = (HttpServletRequest) request;
		HttpServletResponse servletResponse = (HttpServletResponse) response;
		HttpSession session = servletRequest.getSession();
		
		String path = servletRequest.getRequestURI();
		System.out.println("request url:"+path);
		User u =  (User) session.getAttribute("user");
		
		if(path.indexOf("no_filter") > -1){
			chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("jquery-2.2.3.min.js") > -1){
			chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.endsWith(".css")){
			chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.endsWith(".js")){
			chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("/login.jsp") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("login") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("launch_score_task.jsp") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("task_detail.jsp") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("test.jsp") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("jfreePieChart.jsp") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("jfreeBarChart.jsp") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf(".png") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("DisplayChart") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		if(path.indexOf("listCustomersByPage") > -1) {
		    chain.doFilter(servletRequest, servletResponse);
		    return;
		}
		
		else{
			if (u == null) {
				servletResponse.sendRedirect("/mis/login.jsp");
			} else {
				chain.doFilter(request, response);
			}
		}
		
	}

	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
