package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.productdao;
import dto.product;

@WebServlet("/deleteproduct")
public class delete extends HttpServlet{
@Override
protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	int id=Integer.parseInt(req.getParameter("id"));
	productdao dao=new productdao();
	product product=dao.fetchProduct(id);
	dao.deleteproduct(product);
	req.getRequestDispatcher("viewproduct").forward(req, resp);
}
}
