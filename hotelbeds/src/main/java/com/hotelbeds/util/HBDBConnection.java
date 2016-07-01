package com.hotelbeds.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class HBDBConnection {
	private static final String db_url = "jdbc:mysql://52.76.38.70:3306/Bonton";
	private static final String db_driver = "com.mysql.jdbc.Driver";
	private static final String db_username = "root";
	private static final String db_password = "ezee_crm@123";
	
	public static void getConnection() {
		
		try {
			Class.forName(db_driver);
			Connection con = DriverManager.getConnection(db_url, db_username, db_password);

			
			Statement s = con.createStatement();
			String Sql = "select HotelName from MH_SupplierHotelMapping_Test";
			ResultSet rs = s.executeQuery(Sql);

			while (rs.next()) {
				System.out.println(rs.getString("HotelName"));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String...arr) {
		getConnection();
	}
}
