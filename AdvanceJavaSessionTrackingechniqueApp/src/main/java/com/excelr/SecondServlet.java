package com.excelr;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/get")
public class SecondServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		///cookie way
		/*response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		Cookie[] c=request.getCookies();
		
		out.println("<html><body bgcolor=black text=white><center>");
		out.println("<h1>your data is </h1>");
		for(Cookie res:c) {
			out.println(res.getValue()+"<br>");
		}
		out.println("</center></body></html>");*/
		
		///HttpSession way
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
	
		HttpSession hs=request.getSession(false);
		String s1=(String)hs.getAttribute("u1");
		String s2=(String)hs.getAttribute("p1");
		String s3="VZM";
		
		out.println("<html><body bgcolor=black text=white><center>");
		out.println("<h1>your data is </h1>");
		out.println(s1+"<br>");
		out.println(s2+"<br>");
		out.println(s3+"<br>");
		out.println("</center></body></html>");
	}

}
