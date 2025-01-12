package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBCon1 {

	public static void main(String[] args) {
		try {
			// Loading driver
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Creating connection
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "ADVJAVA", "ADVJAVA");

			// Preparing statement
			Statement stm = con.createStatement();

			// Executing query
			ResultSet rs = stm.executeQuery("SELECT * FROM EMP52");

			while (rs.next()) {
				System.out.println(
						rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getInt(4));
			}
			// Close the connection
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
