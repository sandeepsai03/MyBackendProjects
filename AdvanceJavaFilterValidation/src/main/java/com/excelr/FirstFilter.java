package com.excelr;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class FirstFilter extends HttpFilter implements Filter {
       
 	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int age=Integer.parseInt(request.getParameter("va"));
		if(age>=18) {
			chain.doFilter(request, response);
		}
		else {
			out.println("Invalid voter age");
			RequestDispatcher r1=request.getRequestDispatcher("/validate.html");
			r1.include(request, response);
		}
	}

}
