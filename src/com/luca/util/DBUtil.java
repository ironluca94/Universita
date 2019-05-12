package com.luca.util;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	private final static String driver = "com.mysql.jdbc.Driver";
	private final static String db = "jdbc:mysql://localhost:3306/hb_student_tracker";
	private final static String user = "user=hbstudent";
	private final static String password = "password=hbstudent";
	private final static String serverTimezone = "serverTimezone=UTC";
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName (driver);
		return DriverManager.getConnection (db+"?"+user+"&"+password+"&"+serverTimezone); 
	}
}