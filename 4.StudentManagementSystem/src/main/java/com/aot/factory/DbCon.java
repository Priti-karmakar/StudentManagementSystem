package com.aot.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbCon {
	private static Connection con=null;
	public static Connection getConnection() {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","tiger");
		}catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
