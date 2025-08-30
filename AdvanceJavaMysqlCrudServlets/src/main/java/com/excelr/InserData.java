package com.excelr;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertData")
public class InserData extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Connection con=null;
		 try {
			 response.setContentType("text/html");
				PrintWriter out=response.getWriter();
				
				int sno=Integer.parseInt(request.getParameter("sn"));	
				String sname=request.getParameter("snm");
				int smarks=Integer.parseInt(request.getParameter("sm"));
				
			Class.forName("com.mysql.cj.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "saiDATABASE123");
			 String qu="insert into java3_5pm values(?,?,?)";
			 
			 PreparedStatement ps=con.prepareStatement(qu);
			 ps.setInt(1, sno);
			 ps.setString(2,sname);
			 ps.setInt(3, smarks);
			 
			 ps.executeUpdate();
			 out.println("Record inserted successfully");
			 con.close();
			
			
			
		} 
		 catch (ClassNotFoundException | SQLException e){
			
			e.printStackTrace();
		}
		  
	}

}
