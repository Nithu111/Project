package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import dto.user;

@WebServlet("/signup")
public class signup extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		user user=new user();
		user.setEmail(req.getParameter("email"));
		user.setMobile(Long.parseLong( req.getParameter("mobile")));
		user.setPassword(req.getParameter("password"));
		user.setRole(req.getParameter("role"));
		user.setName(req.getParameter("name"));
		
		
		userdao dao=new userdao();
		dao.adduser(user);
	try {
		
		resp.getWriter().print("<h1>Account created sucessful</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}catch(Exception e)
	{
		resp.getWriter().print("<h1>Account already exists, Login here</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
}
}
