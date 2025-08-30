package com.excelr;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/data")
public class LoginValidate extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String un = request.getParameter("un");
        String pwd = request.getParameter("pw");

        if ("sai".equals(un) && "sai123".equals(pwd)) {
            // Forward to success page
            RequestDispatcher r1 = request.getRequestDispatcher("/success.html");
            r1.forward(request, response);
        } else {
            out.println("<p style='color:red'>Invalid credentials</p>");
            // Include login page
            RequestDispatcher r2 = request.getRequestDispatcher("/login.html");
            r2.include(request, response);
        }
    }
}
