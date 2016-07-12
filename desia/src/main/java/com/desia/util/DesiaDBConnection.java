package com.desia.util;

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
public class DesiaDBConnection {
	private static Logger logger = LoggerFactory.getLogger(DesiaDBConnection.class);
	
	/** Host name */
	private static final String host = DesiaUtility.getProperty(DesiaProperties.LOGGINGHOST);
	/** Port number */
	private static final String port = DesiaUtility.getProperty(DesiaProperties.LOGGINGPORT);
	/** Database name to which to connect */
	private static final String db = DesiaUtility.getProperty(DesiaProperties.LOGGINGDB);
	/** Full database url */
	private static final String db_url = "jdbc:mysql://" + host + ":" + port + "/" + db;
	/** Database driver name */
	private static final String db_driver = "com.mysql.jdbc.Driver";
	/** Database user name */
	private static final String db_username = DesiaUtility.getProperty(DesiaProperties.LOGGINGUNAME);
	/** Database password */
	private static final String db_password = DesiaUtility.getProperty(DesiaProperties.LOGGINGUPWD);;
	
	private static Connection connection = null;
	
	private static final String activitySql = 
			"insert into activitytracking(FUNCTION, BTN_RQ, DESIA_RQ, DESIA_RS, BTN_RS, SUPPLIER) "
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
	 * plus Desia API service.
	 * @param opr Desia operation name i.e, search, reprice, confirm or cancel
	 * @param btnRq Request Xml received by Bonton service
	 * @param hbRq Request Xml send to Desia API service
	 * @param hbRs Response Xml recieved from Desia service
	 * @param btnRs Response Xml sent bact by Bonton service
	 * @param splr Name of the supplier or supplier code
	 */
	public static void insert(String opr, String btnRq, String desiaRq, String desiaRs, String btnRs, String splr) {
		try (PreparedStatement ps = connection.prepareStatement(activitySql)) {
			ps.setString(1, opr);
			ps.setString(2, btnRq);
			ps.setString(3, desiaRq);
			ps.setString(4, desiaRs);
			ps.setString(5, btnRs);
			ps.setString(6, splr);
			
			ps.execute();
		} catch (SQLException e) {
			logger.error("Exception occured while inserting the request and responses {}", e);
		}
	}
}
