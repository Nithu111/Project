package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user;

@WebServlet("/sessionvalidation")
public class sessionvalidation extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	user user=(user) req.getSession().getAttribute("user");
	if(user==null)
	{
		resp.getWriter().print("<h1>Session Expired Login Again</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
	else
	{
		req.getRequestDispatcher("addproduct.html").forward(req, resp);
	}
	
}
}
