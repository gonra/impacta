package com.atos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DatabaseFactory {
	private static final String dbUrl="jdbc:sqlite::memory:"; //jdbc:sqlite::memory:
	private static final String dbUser="TAREFA";
	private static final String dbPass="TAREFA";

	private Connection con;
	
	public Connection getConexao() {
		if(con != null) {
			return con;
		}
		return criaConexao();
	}
	
	public Connection criaConexao(){
		try {
			Class.forName("org.sqlite.JDBC");
			con=DriverManager.getConnection(dbUrl);
			if (con != null) {				
				Statement stmt = con.createStatement();
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tbl_aluno (id INTEGER,"
				  +" nome varchar2(30), cpf varchar2(20), turma varchar2(20), media REAL)");
				stmt.close();
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tbl_professor (id INTEGER,"
				  + " nome varchar2(30), cpf varchar2(20), disciplina varchar2(20), salario REAL)");
				stmt.close();
				stmt.executeUpdate("CREATE TABLE IF NOT EXISTS tbl_endereco ( id INTEGER,"
						+ " rua varchar2(30), casa varchar2(20), cidade varchar2(20),"
						+ " cod_aluno INTEGER, cod_professor INTEGER)");
				stmt.close();
				stmt.execute("INSERT INTO tbl_aluno (id,nome,cpf,turma,media) VALUES"
						+ "	 (1,'PEDRO','10000-09','MATEMATICA',9.0);");
				stmt.close();
				stmt.execute("INSERT INTO tbl_professor (id,nome,cpf,disciplina,salario) VALUES"
						+ "	 (1,'MARIA PITANGA','2000-10','CIENCIAS',2000.0);");
				stmt.close();
				stmt.execute("INSERT INTO tbl_endereco (id,rua,casa,cidade,cod_aluno,cod_professor) VALUES"
						+ "	 (1,'RUA DOS BOBOS','ZERO','ILUSAO',1,NULL),"
						+ "	 (2,'RUA XV','15','REPUBLICA',NULL,1)");
			}
			return con;
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
}
