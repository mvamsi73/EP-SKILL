import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAO 
{
	public void init() throws SQLException, ClassNotFoundException
	{
		Connection con=dbUtil.dbConnection();
		Statement st=con.createStatement();
		st.execute("create database if not exists servcrud");
		Statement st3=con.createStatement();
		st3.execute("use servcrud");
		Statement st2=con.createStatement();
		st2.execute("create table if not exists empdata(id int primary key,name varchar(50),email varchar(50),password varchar(50),country varchar(50))");
		con.close();
	}
	public int insert(empbean eb) throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.dbConnection();
		Statement st3=con.createStatement();
		st3.execute("use servcrud");
		PreparedStatement ps=con.prepareStatement("insert into empdata values(?,?,?,?,?)");
		ps.setInt(1, eb.getId());
		ps.setString(2, eb.getName());
		ps.setString(3, eb.getEmail());
		ps.setString(4, eb.getPassword());
		ps.setString(5, eb.getCountry());
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public ResultSet display() throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.dbConnection();
		Statement st3=con.createStatement();
		st3.execute("use servcrud");
		PreparedStatement ps=con.prepareStatement("select * from empdata");
		ResultSet rst=ps.executeQuery();
		return rst;
	}
	public int update(empbean eb,int key) throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.dbConnection();
		Statement st3=con.createStatement();
		st3.execute("use servcrud");
		PreparedStatement ps=con.prepareStatement("update empdata set id=?,name=?,email=?,password=?,country=? where id=?");
		ps.setInt(1,eb.getId() );
		ps.setString(2, eb.getName());
		ps.setString(3, eb.getEmail());
		ps.setString(4, eb.getPassword());
		ps.setString(5, eb.getCountry());
		ps.setInt(6, key);
		int i=ps.executeUpdate();
		con.close();
		return i;
	}
	public int delete(int id) throws ClassNotFoundException, SQLException
	{
		Connection con=dbUtil.dbConnection();
		Statement st3=con.createStatement();
		st3.execute("use servcrud");
		PreparedStatement ps=con.prepareStatement("delete from empdata where id=?");
		ps.setInt(1, id);
		int i=ps.executeUpdate();
		return i;
	}
}
