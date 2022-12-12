<%@page import="dto.product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%List<product> list=(List<product>) session.getAttribute("productlist"); %>
<%char ch='a'; %>
<centre>
<h1 align="center">Place Order</h1>
<div>
<form action="placeorder">
<table border="1" width="500px" height="300px" align="center">
  <tr>
    <th style="color: white;">Product_Name</th>
    <th style="color: white;">Price</th>
    <th style="color: white;">Category</th>
    <th style="color: white;">Select</th>
  </tr>
  <%for(product pro:list){ %>
  <tr>
    <td style="color: white;"><%=pro.getName() %></td>
    <td style="color: white;"><%=pro.getPrice() %></td>
    <td style="color: white;"><%=pro.getCategory() %></td>
    <td style="color: white;"><input type="checkbox" name="<%=ch++%>" value="<%=pro.getId() %>"></td>
  </tr>
  <%} %>
  </table>
 <h1 align="center"> <a href="bill.jsp"><button>Order</button></a>
 
  </form>
  <a href="customerhomepage.html"><button>Back</button></a></h1>
</centre>
</div>
<style>
body{
background-image: url("https://img.freepik.com/premium-photo/colour-smoke-background_71163-197.jpg?w=360");
background-repeat: no-repeat;
background-size: cover;
color: white;
margin-top: 100px;
}
div{
color: white;
}
</style>
</body>
</html>