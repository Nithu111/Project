<%@page import="dto.product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill</title>
</head>
<body>
	
	<centre>
	<h1 align="center">Bill</h1>
	<%
	List<product> list = (List<product>) session.getAttribute("product");%>
	<%double sum = 0; %>
	
	<table style="border: 2px solid white;" cellpadding="10px"
		cellpaddin="10px" align="center">
		<tr>
			<th>Your Order is</th>
		</tr>
		<%
		for (product product : list) {
		%>
		<tr>
			<td><%=product.getName()%></td>
			<td><%=product.getPrice()%></td>
		</tr>
		<%
		sum = sum + product.getPrice();
		%>
		<%
		}
		%>
		<tr>
			<td>Total Bill Amount is: <%=sum%></td>
		</tr>
	</table>
		<h1 align="center"><button onclick="window.print()">Print</button>
			<a href="customerhomepage.html"><button>Back</button></a> </centre></h1>
	<style>
body{
background-image: url("https://img.freepik.com/premium-photo/colour-smoke-background_71163-197.jpg?w=360");
background-repeat: no-repeat;
background-size: cover;
color: white;
margin-top: 100px;
}

</style>
</body>
</html>