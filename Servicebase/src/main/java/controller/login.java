package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userdao;
import dto.user;

@WebServlet("/login")
public class login  extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	
	userdao dao=new userdao();
	List<user> list=dao.login(email);
	if(list.isEmpty())
	{
		resp.getWriter().print("<h1>Enter proper email</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}else {
		user user=list.get(0);
		if(user.getPassword().equals(password))
		{
			req.getSession().setAttribute("user", user);
			if(user.getRole().equals("customer"))
			{
				resp.getWriter().print("<h1>Login Sucessful</h1>");
				req.getRequestDispatcher("customerhomepage.html").include(req, resp);
			}else {
				resp.getWriter().print("<h1>Login Sucessful</h1>");
				req.getRequestDispatcher("adminhomepage.html").include(req, resp);
			}
				
			}else {
				resp.getWriter().print("<h1>Enter proper password</h1>");
				req.getRequestDispatcher("login.html").include(req, resp);
			}
		}
		
	}
}
