<%@page import="dao.productdao"%>
<%@page import="dto.product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upadate Product</title>
</head>
<body >
	<%
	int id = (Integer.parseInt(request.getParameter("id")));
	productdao dao = new productdao();
	product product = dao.fetchProduct(id);
	%>


	<h1 align="center">Edit Product</h1>
	<br>
	<form action="updateproduct">
		Id: <input type="text" name="id" value="<%=product.getId()%>"
			readonly="readonly"><br> <br> Name:<input
			type="text" name="name" value="<%=product.getName()%>"><br>
		<br> Category:<input type="text" name="category"
			value="<%=product.getCategory()%>" readonly="readonly"><br>
		<br> Price:<input type="text" name="price"
			value="<%=product.getPrice()%>"><br> <br>
		<button>Update</button>
		<button type="reset">Cancel</button>
	</form>
	<a href="viewproduct"><button>Back</button></a>
	<style>
body{
background-image: url("https://img.freepik.com/premium-photo/colour-smoke-background_71163-197.jpg?w=360");
background-repeat: no-repeat;
background-size: cover;
color: white;
margin-top: 100px;
</style>
	
</body>
</html>