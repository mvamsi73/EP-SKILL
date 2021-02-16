<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="registerbean.*" %>
    <%@ page import="dbUtil.*" %>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
table th,td{
  border: 1px solid black;
}
</style>
<meta charset="ISO-8859-1">
<title>Display</title>
</head>
<body>
<%
Connection con=dbUtil.getConnection();
	PreparedStatement ps=con.prepareStatement("select s.id,s.name,d.city,d.state,d.postalcode from studentdetails s inner join addressdetails d on s.id=d.id");
	ResultSet rs=ps.executeQuery();
%>
<table align="center" >
<tr><td>REG NUM</td><td>NAME</td><td>CITY</td><td>STATE</td><td>POSTAL CODE</td></tr>
<% while(rs.next()){ %>
<tr><td><%= rs.getLong(1) %></td><td><%= rs.getString(2) %></td><td><%= rs.getString(3) %></td><td><%= rs.getString(4) %></td><td><%= rs.getString(5) %></td></tr>
<% } %>
<tr><td><a href="./logout">LOGOUT</a></td></tr>
</table>
</body>
</html>