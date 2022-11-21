package com.atos.impacta.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.atos.impacta.model.AtosUser;

public class AtosUserDao {

	private final String SQL_PROXIMO_ID = "select max(id_user)+1 as nextid from tbl_user";
	private final String SQL_VALIDA_USER= "select * from tbl_user where username=? and password=?";
	private final String SQL_SALVA_USER= "insert into tbl_user (id_user,username,password,email) values(?,?,?,?)";

	public boolean doLogin(AtosUser user) {

		int id = 1;
		ResultSet rs;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DatabaseFactory.criaConexao();
			stmt = con.prepareStatement(SQL_VALIDA_USER);
			stmt.setString(1,user.getUsername());
			stmt.setString(2,user.getPassword());
			rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception e){
			System.out.println("* Erro GerenteDAO:48");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception ee){
				System.out.println("* Erro GerenteDAO:59");
			}

		}
		return false;
	}

	public boolean doRegister(AtosUser usuario) {

		int id = 1;
		ResultSet rs;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = DatabaseFactory.criaConexao();
			stmt = con.prepareStatement(SQL_PROXIMO_ID);
			rs = stmt.executeQuery();
			if(rs.next()) {
			  id = rs.getInt(1);
			  stmt.close();
			  stmt = con.prepareStatement(SQL_SALVA_USER);
			  stmt.setInt(1, id);
			  stmt.setString(2, usuario.getUsername());
			  stmt.setString(3, usuario.getPassword());
			  stmt.setString(4, usuario.getEmail());
			  int result = stmt.executeUpdate();
			  return (result > 0);
			}
		} catch (Exception e){
			System.out.println("* Erro GerenteDAO:48");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception ee){
				System.out.println("* Erro GerenteDAO:59");
			}

		}
		return false;
	}

}
