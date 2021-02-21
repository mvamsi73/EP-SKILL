<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="dbUtil.*" %>
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
<% Connection con=dbUtil.DBConnection();
Statement st2=con.createStatement();
st2.execute("use jspcrud");
PreparedStatement ps=con.prepareStatement("select * from employees");
ResultSet rst=ps.executeQuery();
%>
<a href="newemployee.html">Add New Employee</a><br>
<h3 align="center">Previous Records</h3>
<table align="center">
<tr><td>ID</td><td>NAME</td><td>PASSWORD</td><td>EMAIL</td><td>COUNTRY</td><td>EDIT</td><td>DELETE</td></tr>
<% while(rst.next())
	{
%>
 <tr><td><%= rst.getInt(1) %></td><td><%= rst.getString(2) %></td><td><%= rst.getString(3) %></td><td><%= rst.getString(4) %></td><td><%= rst.getString(5) %></td><td><form action="update.jsp" method="post"><input type="hidden" name="id" value=<%=rst.getInt(1) %>> <input type="submit" value="update"></form></td><td><form action="delete" method="post"><input type="hidden" name="id" value=<%=rst.getInt(1) %>> <input type="submit" value="delete"></form></td></tr>
	<% 
	}
	%>
</table>
</body>
</html>