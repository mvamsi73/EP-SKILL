package com.student.Connections;
import java.sql.*;
import java.sql.DriverManager;
public class DBUnit {
	final static String forNameURL="com.mysql.cj.jdbc.Driver";
	final static String dbURL="jdbc:mysql://localhost:3306/stuBean";
	final static String username="root";
	final static String password="4163664100Sq@";
	public static Connection DBConnection() throws SQLException,ClassNotFoundException{
		Class.forName(forNameURL);
		Connection con=DriverManager.getConnection(dbURL,username,password);
		return con;
	}

}
