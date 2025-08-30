package com.excelr;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String uname=request.getParameter("un");
		String pwd=request.getParameter("pw");
		
		///cookie way
	/*	if(uname!=null) {
			Cookie c1=new Cookie("u1",uname);
			response.addCookie(c1);
		}
		if(pwd!=null) {
			Cookie c2=new Cookie("u2",pwd);
			response.addCookie(c2);
		}*/
		
		///httpSession way
		if(uname!=null) {
			HttpSession hs1=request.getSession();
			hs1.setAttribute("u1", uname);
			
		}
		if(pwd!=null) {
			HttpSession hs2=request.getSession();
			hs2.setAttribute("u2", pwd);
		}
		out.println("<html><body bgcolor=red text=yellow><center>");
		out.println("<h1>Data is added to FirstServlet </h1>");
		out.println("<a href=get>Click here to go to Secondservlet</a>");
		out.println("</center></body></html>");
	}

}
