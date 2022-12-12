package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dto.product;

@WebServlet("/addcustomerproduct")
public class addcustomerproduct  extends HttpServlet{
 @Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	product product=new product();
	product.setName(req.getParameter("name"));
	product.setPrice(Double.parseDouble(req.getParameter("price")));
	product.setCategory(req.getParameter("category"));
	
	productdao dao=new productdao();
	dao.addproduct(product);
	
	resp.getWriter().print("<h1>Ordered Sucessful</h1>");
	req.getRequestDispatcher("customerhomepage.html").include(req, resp);
	}
}
