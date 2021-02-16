package dbUtil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil 
{
	final static String fornameurl="com.mysql.cj.jdbc.Driver";
	final static String dburl="jdbc:mysql://localhost:3306/aggregation";
	final static String username="root";
	final static String password="root";
	public static Connection getConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(fornameurl);
		Connection con=DriverManager.getConnection(dburl,username,password);
		return con;
	}

}
