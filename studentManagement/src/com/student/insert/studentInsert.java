package com.student.insert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import com.student.stuBean;
import com.student.Connections.DBUnit;

public class studentInsert {
	public int StudentInsert(stuBean student) throws ClassNotFoundException, SQLException 
	{
		Connection con=DBUnit.DBConnection();
		PreparedStatement ps=con.prepareStatement("insert into student values(?,?,?)");
		ps.setLong(1, student.getRegnum());
		ps.setString(2, student.getName());
		ps.setString(3, student.getEmail());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public int StudentDelete(stuBean student,String id) throws ClassNotFoundException, SQLException 
	{
		Connection con=DBUnit.DBConnection();
		PreparedStatement ps=con.prepareStatement("delete from student where Regnum="+id);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public int StudentUpdate(int para,String upval,long id) throws ClassNotFoundException, SQLException
	{
		Connection con=DBUnit.DBConnection();
		String qry="";
		if(para==1) {
			qry="update student "+"set name=? "+"where Regnum=?";
		}
		else if(para==2) {
			qry="update student "+"set Regnum=? "+"where Regnum=?";
		}
		else
		{
			qry="update student "+"set email=? "+"where Regnum=?";
		}
		PreparedStatement ps=con.prepareStatement(qry);
		ps.setString(1, upval);
		ps.setLong(2, id);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public  void Retrive() throws ClassNotFoundException, SQLException
	{
		Connection con=DBUnit.DBConnection();
		PreparedStatement ps=con.prepareStatement("select * from student");
		ResultSet rst=ps.executeQuery();
		System.out.println("Regnum\t\tName\t\tEmail");
		while(rst.next())
		{
			System.out.println(rst.getLong(1)+"\t"+rst.getString(2)+"\t\t"+rst.getString(3));
		}
		con.close();
	}
	{
		
	}

}