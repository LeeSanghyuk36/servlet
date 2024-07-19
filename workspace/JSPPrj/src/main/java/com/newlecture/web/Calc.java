package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req
							, HttpServletResponse res) 
							throws ServletException
							, IOException 
		{
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String op = req.getParameter("operator");
		int x = 0, y = 0;
		if (x_ != null && y_ != null && !x_.equals("") && !y_.equals("")) {
			x = Integer.parseInt(x_);
			y = Integer.parseInt(y_);
//			System.out.printf("result is");
//			out.println("plus ");
//			out.println(x+y );
//			out.println("<br > minus ");
//			out.println(x-y);
//			out.println("<br > multiply ");
//			out.println(x*y);
//			out.println("<br > divine");
//			out.println(x/y);
		}
		int result = 0;
		if (op.equals("plus")) {
			result = x+y;			
		}else if (op.equals("minus")) {
			result = x-y;			
		}
		out.printf("result is %d\n", result);
	}

}
