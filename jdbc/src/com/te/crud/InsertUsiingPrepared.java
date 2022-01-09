package com.te.crud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.util.Scanner;



public class InsertUsiingPrepared {

	public static void main(String[] args) {
		Connection connection=null;
		PreparedStatement statement=null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/technoelevat", "root", "root");
			 statement = connection.prepareStatement(/*"delete from sweets where id=?"*/"insert into sweets values(?,?,?,?)");
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the id of the sweet");
			int id=scanner.nextInt();
			System.out.println("Enter the name of the sweet");
			String sweet=scanner.next();
			statement.setInt(1, id);
			statement.setString(2, sweet);
			statement.setDouble(3, 50);
			statement.setInt(4, 2);
			int executeUpdate = statement.executeUpdate();
			System.out.println(executeUpdate);
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			if(connection!=null) {
				try {
					connection.close();
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
			}
			if(statement!=null) {
				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
