package com.excelr;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
        //output in console
		System.out.println("welcome to servlets how are you");
		
		//decide the MIME Type
		response.setContentType("text/html");
		
		//output in browser
		PrintWriter pw=response.getWriter();
		pw.println("welcome to servlets and bye bye");
	}

}
