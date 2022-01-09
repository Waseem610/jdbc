package com.te.Properties;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) {
		Connection connection = null;
		Statement createStatement = null;
		try {
			FileReader fileReader = new FileReader("C:\\Users\\Waseem\\Desktop\\Properties.txt");
			Properties properties = new Properties();
			properties.load(fileReader);
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/technoelevate", properties);
			createStatement = connection.createStatement();
			createStatement.execute("insert into playlist values('believer', 'imagineDragon')");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
