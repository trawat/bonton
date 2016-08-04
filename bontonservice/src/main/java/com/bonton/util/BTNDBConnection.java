package com.bonton.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to connect to a logging database and save request and responses.
 * @author Tirath
 */
public class BTNDBConnection {
	private static Logger logger = LoggerFactory.getLogger(BTNDBConnection.class);
	
	/** Host name */
	private static final String host = BTNUtility.getProperty(BTNProperties.LOGGINGHOST);
	/** Port number */
	private static final String port = BTNUtility.getProperty(BTNProperties.LOGGINGPORT);
	/** Database name to which to connect */
	private static final String db = BTNUtility.getProperty(BTNProperties.LOGGINGDB);
	/** Full database url */
	private static final String db_url = "jdbc:mysql://" + host + ":" + port + "/" + db;
	/** Database driver name */
	private static final String db_driver = "com.mysql.jdbc.Driver";
	/** Database user name */
	private static final String db_username = BTNUtility.getProperty(BTNProperties.LOGGINGUNAME);
	/** Database password */
	private static final String db_password = BTNUtility.getProperty(BTNProperties.LOGGINGUPWD);;
	
	private static Connection connection = null;
	
	public static final String SUPPLIER_ID = "SUPPLIER_ID"; 
	
	/** enabled endpoint sql */
	private static final String eepSql = 
			"SELECT SUPPLIER_ID FROM supplier_master "
		   +"WHERE ACTIVE = 'Y' ";
	
	private static final String eepSqlWithSplr = 
			"SELECT SUPPLIER_ID FROM supplier_master "
		   +"WHERE ACTIVE = 'Y' AND SUPPLIER_ID = ?";
	
	static {
		try {
			Class.forName(db_driver);
			connection = DriverManager.getConnection(db_url, db_username, db_password);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error("Unable to conncet to {} database", db);
		}
	}

	/**
	 * 
	 * @return
	 */
	public static final List<String> getEnabledEndPoints() {
		List<String> endPointIDs = new LinkedList<>();
		try (PreparedStatement ps = getConnection().prepareStatement(eepSql);
				ResultSet rs = ps.executeQuery();) {
			
			while (rs.next()) {
				endPointIDs.add(rs.getString(SUPPLIER_ID));
			}
			
		} catch (Exception e) {
			logger.error("{} occured while fetching enabled end points", e);
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sQLException) {
					logger.error("Unable to close {} connection {}", db, sQLException);
				}
			}
		} 
		return endPointIDs;
	}
	
	public static final List<String> getEnabledEndPoints(String supplier) {
		List<String> endPointIDs = new LinkedList<>();
		try (PreparedStatement ps = getConnection().prepareStatement(eepSqlWithSplr);) {
				ps.setString(0, supplier);
				
				ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				endPointIDs.add(rs.getString(SUPPLIER_ID));
			}
			
		} catch (Exception e) {
			logger.error("{} occured while fetching enabled end points", e);
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException sQLException) {
					logger.error("Unable to close {} connection {}", db, sQLException);
				}
			}
		} 
		return endPointIDs;
	}
	
	private static Connection getConnection() {
		try {
			if (connection == null || !connection.isValid(0)) {
				logger.info("{} database connection was null", db);
				try {
					connection = DriverManager.getConnection(db_url, db_username, db_password);
				} catch (SQLException e) {
					logger.error("Unable to connect to {} database", db);
					throw e;
				}
			}
		} catch (SQLException e1) {
			logger.error("Please check the {} database instance is up and running", db);
		}
		
		return connection;
	}
	
	public static void reInstateConnection() {
		getConnection();
	}
}
