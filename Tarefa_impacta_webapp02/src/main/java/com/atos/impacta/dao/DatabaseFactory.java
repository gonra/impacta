package com.atos.impacta.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseFactory {
	private static final String dbUrl="jdbc:oracle:thin:@localhost:1521:xe";
	private static final String dbUser="TAREFA";
	private static final String dbPass="TAREFA";

	public static Connection criaConexao(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
			return con;
		} catch (Exception e) {

		}
		return null;
	}
}
