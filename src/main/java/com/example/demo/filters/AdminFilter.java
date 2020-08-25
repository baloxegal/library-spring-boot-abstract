package com.example.demo.filters;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.example.demo.services.UserService;

@WebFilter(filterName = "adminFilter", urlPatterns = {"/admin/*"})
public class AdminFilter implements Filter {
	@Inject
	UserService userService = new UserService();

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest requestHttp = (HttpServletRequest) request;
		
		System.out.println("Starting" + requestHttp.getRequestURI());
				
		chain.doFilter(request, response);
		
		System.out.println("Continued" + requestHttp.getRequestURI());
		
		userService.signIn(email, password)
		
		
	}

}
