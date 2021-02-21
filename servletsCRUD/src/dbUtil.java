import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbUtil 
{
	final static String forname="com.mysql.cj.jdbc.Driver";
	final static String dburl="jdbc:mysql://localhost:3306";
	final static String username="root";
	final static String password="root";
	public static Connection dbConnection() throws ClassNotFoundException, SQLException
	{
		Class.forName(forname);
		Connection con=DriverManager.getConnection(dburl,username,password);
		return con;
	}
}
