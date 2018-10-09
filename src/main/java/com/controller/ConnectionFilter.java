package com.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class ConnectionFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Object connError = request.getServletContext().getAttribute("connError");
		if (connError != null) {
			String error = String.valueOf(connError);
			request.getServletContext().removeAttribute("connError");
			request.setAttribute("errorMsg", error);
			request.getRequestDispatcher("/error.jsp").forward(request, response);
		}
		chain.doFilter(request, response);
	}

}
