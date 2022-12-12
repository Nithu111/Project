package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dto.product;
import dto.user;

@WebServlet("/viewproduct")
public class viewproduct extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		user user = (user) req.getSession().getAttribute("user");
		if (user == null) {
			resp.getWriter().print("<h1>Session Expired Login Again</h1>");
			req.getRequestDispatcher("login.html").include(req, resp);
		} else {
			productdao dao = new productdao();
			List<product> list = dao.fetchProducts();

			if (list.isEmpty()) {
				resp.getWriter().print("<h1>There Are No products present</h1>");
				req.getRequestDispatcher("adminhomepage.html").include(req, resp);
			} else {

				req.getSession().setAttribute("productlist", list);
				req.getRequestDispatcher("fetchproduct.jsp").forward(req, resp);
			}
		}
	}
}
