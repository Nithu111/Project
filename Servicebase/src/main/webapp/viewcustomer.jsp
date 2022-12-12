<%@page import="java.util.List"%>
<%@page import="dto.user"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customers</title>
</head>
<body>
<%List<user> list=(List<user>)session.getAttribute("customerlist"); %>
<h1 align="center">Products</h1><br>
<table border="1" align="center" cellpadding="10">
<tr>
<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Mobile</th>
<th>Password</th>
</tr>
<% for(user u:list){%>
<tr>
<th><%=u.getId() %></th>
<th><%=u.getName() %></th>
<th><%=u.getEmail() %></th>
<th><%=u.getPassword() %></th>
<th><%=u.getMobile() %></th>
</tr>
<%} %>
</table>
<br>
<h1 align="center"><a href="adminhomepage.html"><button>Back</button></a></h1>
<style>
body{
background-image: url("https://img.freepik.com/premium-photo/colour-smoke-background_71163-197.jpg?w=360");
background-repeat: no-repeat;
background-size: cover;
color: white;
margin-top: 50px;
}
</style>

</body>
</html>