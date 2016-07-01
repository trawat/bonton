package com.hotelbeds.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HBDBConnection {
	private static final String db_url = "jdbc:mysql://localhost:3306/Bonton";
	private static final String db_driver = "com.mysql.jdbc.Driver";
	private static final String db_username = "root";
	private static final String db_password = "";
	
	private static Connection connection = null;
	private static PreparedStatement ps = null;
	
	private static final String activitySql = 
			"insert into Bonton.activitytracking(FUNCTION, BTN_RQ, HB_RQ, HB_RS, BTN_RS, SUPPLIER) "
			+ "values (?, ?, ?, ?, ?, ?)";
	
	static {
		try {
			Class.forName(db_driver);
			connection = DriverManager.getConnection(db_url, db_username, db_password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void insert(String opr, String btnRq, String hbRq, String hbRs, String btnRs, String splr) {
		try {
			ps = connection.prepareStatement(activitySql);
			ps.setString(1, opr);
			ps.setString(2, btnRq);
			ps.setString(3, hbRq);
			ps.setString(4, hbRs);
			ps.setString(5, btnRs);
			ps.setString(6, splr);
			
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
