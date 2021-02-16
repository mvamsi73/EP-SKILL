package DAO;
import registerbean.*;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbUtil.*;
public class DAO 
{
	public int insertinstudent (registerbean sb) throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.getConnection();
		Statement ps=con.createStatement();
		ps.execute("create table if not exists studentdetails(id bigint primary key,name varchar(20))");
		PreparedStatement ps2=con.prepareStatement("insert into studentdetails values(?,?)");
		ps2.setLong(1,sb.getId());
		ps2.setString(2, sb.getName());
		int i=ps2.executeUpdate();
		return i;
	}
	public int insertinaddress(registerbean rb) throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.getConnection();
		Statement st=con.createStatement();
		st.execute("create table if not exists addressdetails(id int primary key,city varchar(20),state varchar(20),postalcode int)");
		PreparedStatement ps=con.prepareStatement("insert into addressdetails values(?,?,?,?)");
		ps.setLong(1,rb.getId());
		ps.setString(2, rb.getAb().getCity());
		ps.setString(3,rb.getAb().getState());
		ps.setInt(4, rb.getAb().getPostal());
		int i=ps.executeUpdate();
		return i;
	}

}
