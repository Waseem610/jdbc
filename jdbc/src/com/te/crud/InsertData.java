package com.te.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {

	public static void main(String[] args) {
		Connection connection = null;
		Statement createStatement = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/technoelevat", "root", "root");
			createStatement = connection.createStatement();
			boolean execute = createStatement.execute("Insert into sweets values(101,'MysorePaak',10,1)");
			boolean execute1 = createStatement.execute("Insert into sweets values(102,'Gulabjamun',20,1)");
			
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(createStatement!=null) {
				try {
					createStatement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			}
		}
	}

}
