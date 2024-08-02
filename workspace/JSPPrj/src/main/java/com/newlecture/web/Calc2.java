package com.newlecture.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req
							, HttpServletResponse res) 
							throws ServletException
							, IOException 
		{
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		Cookie[] cookies = req.getCookies();
		
		res.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		String v_ = req.getParameter("v");
		String op = req.getParameter("operator");
		int v = 0;
		if (v_ != null && !v_.equals("") ) {
			v = Integer.parseInt(v_);
		}
		
		// calc
		if (op.equals("=")) {
			
//			int x = (Integer)application.getAttribute("value");
//			int x = (Integer)session.getAttribute("value");
			
			//쿠키
			int x = 0;
//			Cookie c = cookies[0];
			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
		
			}
			int y = v;
//			String operator = (String)application.getAttribute("op");;
//			String operator = (String)session.getAttribute("op");;
			
			//쿠키
			String operator = "";
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
		
			}
			int result = 0;
			
			if (operator.equals("+")) {
				result = x+y;
			} else if (operator.equals("-")) {
				result = x-y;
			}
			res.getWriter().printf("result is %d\n", result);
		
		// save
		}else {
	//		application.setAttribute("value", v);
	//		application.setAttribute("op", op);
	//		session.setAttribute("value", v);
	//		session.setAttribute("op", op);
		
			Cookie valueCookie= new Cookie("value", String.valueOf(v));
			Cookie opCookie= new Cookie("op", op);
			res.addCookie(valueCookie);
			res.addCookie(opCookie);
			
			
			
		}
		
	}

}
