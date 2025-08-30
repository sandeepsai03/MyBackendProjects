package com.excelr;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class VoteValidation extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String vname=request.getParameter("vn");
		if(vname.equals("saisandeep")) {
			out.println("welcome to elections you are eligible for vote(valid age,location and name)");
			
		}
		else {
			out.println("Invalid name");
		}
	}

}
