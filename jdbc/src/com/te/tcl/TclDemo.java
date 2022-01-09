package com.te.tcl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class TclDemo {

	public static void main(String[] args) {
		Connection connection = null;
		Statement statement = null;
		Savepoint setSavepoint = null;
		String url = "jdbc:mysql://localhost:3306/technoelevate";
		try {
			connection = DriverManager.getConnection(url, "root", "root");
			statement = connection.createStatement();
			connection.setAutoCommit(false);
			statement.execute("insert into trans values(1,'unlock the using fingerPrint')");
			statement.execute("insert into trans values(2,'Enter the pin')");
			statement.execute("insert into trans values(3,'Check The balance')");
			System.out.println("Balance is 8988989");
			setSavepoint = connection.setSavepoint();
			statement.execute("insert into trans values(4,'Debiting the amount')");
			statement.execute("insert into trans values(5,'transfer through network')");
			boolean execute = statement.execute("insert into trans values(6,'Amount credited')");
			System.out.println(execute);
			System.out.println("Transaction completed ! Tiding");
			connection.commit();
		} catch (SQLException e) {
			try {
				connection.rollback(setSavepoint);
				connection.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				
			}
			System.out.println("Transaction failed");
		}
	}

}
