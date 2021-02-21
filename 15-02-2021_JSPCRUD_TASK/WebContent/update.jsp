<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
    <%@ page import="dbUtil.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee</title>
</head>
<body>
<% 
int id=Integer.parseInt(request.getParameter("id"));
Connection con=dbUtil.DBConnection();
Statement st2=con.createStatement();
st2.execute("use jspcrud");
PreparedStatement ps=con.prepareStatement("select * from employees where empid=?");
ps.setInt(1, id);
ResultSet rst=ps.executeQuery();
%>
<form action="update" method="post">
<table align="center">
<% while(rst.next()){ %>
<tr><td>Employee ID:</td><td><input type="text" placeholder= <%= rst.getInt(1) %> name="empid" value=<%=rst.getInt(1) %>></td></tr>
<tr><td>Employee Name:</td><td><input type="text" placeholder= <%= rst.getString(2) %> name="name" value=<%=rst.getString(2) %>></td></tr>
<tr><td>Employee Password:</td><td><input type="password" placeholder= <%= rst.getString(3) %> name="password" value=<%=rst.getString(3) %>></td></tr>
<tr><td>Employee Email:</td><td><input type="email" placeholder= <%= rst.getString(4) %> name="email" value=<%=rst.getString(4) %>></td></tr>
<tr><td>Employee Country:</td><td><select id="Country" name="country">
  <option value="select"><%=rst.getString(5) %></option>
  <option value="India">India</option>
  <option value="USA">USA</option>
  <option value="Australia">Australia</option>
  <option value="Canada">Canada</option>
</select></td></tr>
<tr><td><input type="hidden" name="key" value=<%=rst.getInt(1) %>></td></tr>
<tr><td><input type="submit" value="Edit and Save"></td></tr>
<%}; %>
</table>
</form>
</body>
</html>