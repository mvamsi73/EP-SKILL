package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import bean.empbean;
import dbUtil.*;
public class DAO 
{
	public void init() throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.DBConnection();
		Statement st=con.createStatement();
		st.execute("create database if not exists jspcrud");
		Statement st2=con.createStatement();
		st2.execute("use jspcrud");
		Statement st3=con.createStatement();
		st3.execute("create table if not exists employees(empid int primary key,name varchar(500),password varchar(500),email varchar(500),country varchar(20))");
		con.close();
	}
	public int insert(empbean eb) throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.DBConnection();
		Statement st2=con.createStatement();
		st2.execute("use jspcrud");
		PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?,?,?)");
		ps.setInt(1, eb.getEmpid());
		ps.setString(2, eb.getName());
		ps.setString(3,eb.getPassword());
		ps.setString(4, eb.getEmail());
		ps.setString(5, eb.getCountry());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public int update(empbean eb,int key) throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.DBConnection();
		Statement st2=con.createStatement();
		st2.execute("use jspcrud");
		PreparedStatement ps=con.prepareStatement("update employees set empid=?,name=?,password=?,email=?,country=? where empid=?");
		ps.setInt(1, eb.getEmpid());
		ps.setString(2, eb.getName());
		ps.setString(3, eb.getPassword());
		ps.setString(4, eb.getEmail());
		ps.setString(5, eb.getCountry());
		ps.setInt(6, key);
		int i=ps.executeUpdate();
		return i;
	}
	public int delete(int key) throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.DBConnection();
		Statement st=con.createStatement();
		st.execute("use jspcrud");
		PreparedStatement ps=con.prepareStatement("delete from employees where empid=?");
		ps.setInt(1, key);
		int i=ps.executeUpdate();
		return i;
	}

}
