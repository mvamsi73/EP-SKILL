package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil 
{
	final static String fornameurl="com.mysql.cj.jdbc.Driver";
	final static String dbURL="jdbc:mysql://localhost:3306";
	final static String user="root";
	final static String password="root";
	public static Connection DBConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(fornameurl);
		Connection con=DriverManager.getConnection(dbURL,user,password);
		return con;
	}
    
}
