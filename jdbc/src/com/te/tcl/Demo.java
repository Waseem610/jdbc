package com.te.tcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class Demo {
	public static void main(String[] args) {
		Savepoint setSavepoint=null;
		Connection connection=null;
		Statement createStatement =null;
	try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/technoelevat","root","root");
 createStatement = connection.createStatement();
		connection.setAutoCommit(false);
		ResultSet executeQuery = createStatement.executeQuery("select * from phone");
	 setSavepoint = connection.setSavepoint();
	
		connection.commit();
	} catch (SQLException e) {
		try {
			connection.rollback(setSavepoint);
			connection.commit();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
	}
}
