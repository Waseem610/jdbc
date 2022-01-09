package com.te.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RetriveData {

	public static void main(String[] args) {
		Connection connection=null;
		Statement statement=null;
		try {
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/technoelevat", "root", "root");
		 statement=connection.createStatement();
		
		 ResultSet result = statement.executeQuery("Select *from sweets where cost=10");
		 while(result.next()) {
			 System.out.print(result.getString(1)+" ");
			 System.out.print(result.getString(2)+" ");
			 System.out.print(result.getString(3)+" ");
			 System.out.println(result.getString(4)+" ");
		 }
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
