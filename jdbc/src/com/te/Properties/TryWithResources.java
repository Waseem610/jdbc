package com.te.Properties;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class TryWithResources {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/technoelevate","root","root");
				Statement statement=connection.createStatement()) {
			boolean execute = statement.execute("select * from playlist");
			System.out.println(execute);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
