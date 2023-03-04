package com.example.legacy.filter;

import jakarta.servlet.*;

import java.io.IOException;


public class HelloFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("helloFilter init.");
        String firstName = filterConfig.getInitParameter("firstName");
        String lastName = filterConfig.getInitParameter("lastName");
        System.out.println("First Name is " + firstName);
        System.out.println("Last Name is " + lastName);
    }

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        System.out.println("helloFilter processing.");
        chain.doFilter(request, response);
	}

}
