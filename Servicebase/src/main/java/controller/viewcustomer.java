package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dao.userdao;
import dto.product;
import dto.user;

@WebServlet("/viewcustomer")
public class viewcustomer extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		user user = (user) req.getSession().getAttribute("user");
		if (user == null) {
			resp.getWriter().print("<h1>Session Expired Login Again</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			userdao dao = new userdao();
			List<user> list = dao.viewcustomer();

			req.getSession().setAttribute("customerlist", list);
			req.getRequestDispatcher("viewcustomer.jsp").forward(req, resp);
		}

	}
}
