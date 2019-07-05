package com.josipk;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
		int k = i + j;
		
		PrintWriter out = resp.getWriter();
		
		out.println("result is: " + k);
		
		//To call another servlet we can use a Request Dispatcher or Redirect
		// Session management
		req.setAttribute("k", k);
		
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("sq");
		requestDispatcher.forward(req, resp);
	}

}
