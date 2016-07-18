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
		try (PreparedStatement ps = connection.prepareStatement(eepSql);
				ResultSet rs = ps.executeQuery();) {
			
			while (rs.next()) {
				endPointIDs.add(rs.getString(SUPPLIER_ID));
			}
			
		} catch (SQLException e) {
			logger.error("Exception occured while inserting the request and responses {}", e);
		}
		return endPointIDs;
	}
}
