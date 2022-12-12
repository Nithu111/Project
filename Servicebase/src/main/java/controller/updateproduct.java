package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dto.product;

@WebServlet("/updateproduct")
public class updateproduct extends HttpServlet {
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	product product=new product();
	product.setId(Integer.parseInt(req.getParameter("id")));
	product.setName(req.getParameter("name"));
	product.setCategory(req.getParameter("category"));
	product.setPrice(Double.parseDouble(req.getParameter("price")));
	
	productdao dao=new productdao();
	dao.updateproduct(product);
	
	req.getRequestDispatcher("adminhomepage.html").forward(req, resp);
}
}
