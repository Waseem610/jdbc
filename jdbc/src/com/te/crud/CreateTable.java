package com.te.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class CreateTable {

	public static void main(String[] args) {
		Connection connection = null;
		Statement createStatement = null;
		try {
			// 1st loading or register the driver
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			// Create the connection
			connection = DriverManager
					.getConnection("jdbc:mysql://localhost:3306/technoelevat?user=root&password=root");
			// creating a platform
			createStatement = connection.createStatement();
			// Execute Query
			createStatement.execute("create table sweets (id int,name varchar(40),cost double,quantity int)");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (createStatement != null) {
				try {
					createStatement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
