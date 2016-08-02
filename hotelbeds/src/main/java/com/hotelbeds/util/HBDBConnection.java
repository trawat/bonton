package com.hotelbeds.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class to connect to a logging database and save request and responses.
 * @author Tirath
 */
public class HBDBConnection {
	private static Logger logger = LoggerFactory.getLogger(HBDBConnection.class);
	
	/** Host name */
	private static final String host = HBUtility.getProperty(HBProperties.LOGGINGHOST);
	/** Port number */
	private static final String port = HBUtility.getProperty(HBProperties.LOGGINGPORT);
	/** Database name to which to connect */
	private static final String db = HBUtility.getProperty(HBProperties.LOGGINGDB);
	/** Full database url */
	private static final String db_url = "jdbc:mysql://" + host + ":" + port + "/" + db;
	/** Database driver name */
	private static final String db_driver = "com.mysql.jdbc.Driver";
	/** Database user name */
	private static final String db_username = HBUtility.getProperty(HBProperties.LOGGINGUNAME);
	/** Database password */
	private static final String db_password = HBUtility.getProperty(HBProperties.LOGGINGUPWD);;
	
	private static Connection connection = null;
	
	private static final String activitySql = 
			"insert into activitytracking(FUNCTION, BTN_RQ, HB_RQ, HB_RS, BTN_RS, SUPPLIER) "
			+ "values (?, ?, ?, ?, ?, ?)";
	
	static {
		try {
			Class.forName(db_driver);
			connection = DriverManager.getConnection(db_url, db_username, db_password);
		} catch (ClassNotFoundException | SQLException e) {
			logger.error("Unable to conncet to {} database", db);
		}
	}

	/**
	 * DML function to log request and responses for each operation provided by Bonton
	 * plus HotelBeds API service.
	 * @param opr HotelBeds operation name i.e, search, reprice, confirm or cancel
	 * @param btnRq Request Xml received by Bonton service
	 * @param hbRq Request Xml send to HotelBeds API service
	 * @param hbRs Response Xml recieved from HotelBeds service
	 * @param btnRs Response Xml sent bact by Bonton service
	 * @param splr Name of the supplier or supplier code
	 */
	public static void insert(String opr, String btnRq, String hbRq, String hbRs, String btnRs, String splr) {
		try (PreparedStatement ps = getConnection().prepareStatement(activitySql)) {
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
}
