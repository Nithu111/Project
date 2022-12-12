<%@page import="dto.product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Fetching</title>
</head>
<body>
<%List<product> list=(List<product>)session.getAttribute("productlist"); %>
<h1 align="center">Products</h1><br>
<table border="1" align="center" cellpadding="20" >
<tr>
<th>ID</th>
<th>Name</th>
<th>Price</th>
<th>Category</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<% for(product p:list){%>
<tr>
<th><%=p.getId() %></th>
<th><%=p.getName() %></th>
<th><%=p.getPrice() %></th>
<th><%=p.getCategory() %></th>
<th><a href="updateproduct.jsp?id=<%=p.getId() %>"><button>Edit</button></a></th>
<th><a href="deleteproduct?id=<%=p.getId() %>"><button>Delete</button></a></th>
</tr>
<%} %>
</table>
<br>
<h1 align="center"><a href="adminhomepage.html" id="e"><button>Back</button></a></h1>
<style>
body{
background-image: url("https://img.freepik.com/premium-photo/colour-smoke-background_71163-197.jpg?w=360");
background-repeat: no-repeat;
background-size: cover;
color: white;
justify-content: center;
margin-top: 50px;

}
h1{
align-items: center;
}

</style>
</body>
</html>