package com.josipk;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sq")
public class SquareServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int k = 0;
		Cookie cookies[] = req.getCookies();
		
		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("k"))
				k = Integer.parseInt(cookie.getValue()); 
		}
		
		k = k * k;
		
		PrintWriter out = resp.getWriter();
		out.println("Result is: " + k);
		
		System.out.println("sq called");	
	}
}
