package com.te.storedprocedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class StoredProcedure {

	public static void main(String[] args) {
		Connection connection = null;
		CallableStatement call = null;

		try {
			String url = "jdbc:mysql://localhost:3306/technoelevate";
			connection = DriverManager.getConnection(url, "root", "root");
			call = connection.prepareCall("call puts(?,?)");
			// taking inputs from the user
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println("Enter the name of the song");
				String songName = scanner.next();
				if (songName.equals("exit")) {
					break;
				}
				System.out.println("Enter the singer name ");
				String singerName = scanner.next();
				// Assigning the values to table
				call.setString(1, songName);
				call.setString(2, singerName);
				call.execute();
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
