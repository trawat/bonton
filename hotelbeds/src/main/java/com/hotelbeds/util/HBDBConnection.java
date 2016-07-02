package com.hotelbeds.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hotelbeds.service.HBService;

public class HBDBConnection {
	private static Logger logger = LoggerFactory.getLogger(HBDBConnection.class);
	
	private static final String host = "localhost";
	private static final String port = "3306";
	private static final String db = "Bonton";
	private static final String db_url = "jdbc:mysql://" + host + ":" + port + "/" + db;
	private static final String db_driver = "com.mysql.jdbc.Driver";
	private static final String db_username = "root";
	private static final String db_password = "";
	
	private static Connection connection = null;
	
	private static final String activitySql = 
			"insert into Bonton.activitytracking(FUNCTION, BTN_RQ, HB_RQ, HB_RS, BTN_RS, SUPPLIER) "
			+ "values (?, ?, ?, ?, ?, ?)";
	
	static {
		try {
			Class.forName(db_driver);
			connection = DriverManager.getConnection(db_url, db_username, db_password);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error("Unable to conncet to {} database", db);
		}
	}

	public static void insert(String opr, String btnRq, String hbRq, String hbRs, String btnRs, String splr) {
		try (PreparedStatement ps = connection.prepareStatement(activitySql)) {
			ps.setString(1, opr);
			ps.setString(2, btnRq);
			ps.setString(3, hbRq);
			ps.setString(4, hbRs);
			ps.setString(5, btnRs);
			ps.setString(6, splr);
			
			ps.execute();
		} catch (SQLException e) {
			logger.error("Exception occured while inserting the request and responses {}", e);
		}
	}
}
