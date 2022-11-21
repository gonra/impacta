package com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.atos.model.Aluno;
import com.atos.model.Endereco;
import com.atos.model.Endereco;

public class EnderecoDao {

	private final String SQL_PROXIMO_ID = "select max(id)+1 as nextid from tbl_endereco";
	private final String SQL_LISTAR_ENDERECO = "select * from tbl_endereco";
	private final String SQL_LER_ENDERECO= "select * from tbl_endereco where id=?";
	private final String SQL_LER_ENDERECO_ALUNO= "select * from tbl_endereco where cod_aluno=?";
	private final String SQL_LER_ENDERECO_PROFESSOR= "select * from tbl_endereco where cod_professor=?";
	private final String SQL_SALVAR_ENDERECO= "insert into tbl_endereco (id,rua,casa,cidade,cod_aluno,cod_professor) values(?,?,?,?,?,?)";
	private final String SQL_ATUALIZAR_ENDERECO= "update tbl_endereco set rua=?,casa=?,cidade=?,cod_aluno=?, cod_professor=? where id=?";
	private final String SQL_DELETAR_ENDERECO= "delete from tbl_endereco where id=?";
	
	private DatabaseFactory factory;
	
	public EnderecoDao() {
		factory = new DatabaseFactory();
	}
	
	public Endereco carregarEnderecoById(int id) {
		ResultSet rs;
		int retorno = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();

			stmt = con.prepareStatement(SQL_LER_ENDERECO);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt(1));
				endereco.setRua(rs.getString(2));
				endereco.setCasa(rs.getString(3));
				endereco.setCidade(rs.getString(4));

				return endereco;
			} else {
				return null;
			}
		} catch (Exception e){
			System.out.println("* Erro EnderecoDAO:51");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
				//				if(con != null) {
				//					con.close();
				//				}
			} catch (Exception ee){
				System.out.println("* Erro EnderecoDAO:62");
			}

		}
		return null;
	}
	
	public Endereco carregarEnderecoByIdAluno(int id) {
		ResultSet rs;
		int retorno = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();

			stmt = con.prepareStatement(SQL_LER_ENDERECO_ALUNO);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt(1));
				endereco.setRua(rs.getString(2));
				endereco.setCasa(rs.getString(3));
				endereco.setCidade(rs.getString(4));

				return endereco;
			} else {
				return null;
			}
		} catch (Exception e){
			System.out.println("* Erro EnderecoDAO:51");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
				//				if(con != null) {
				//					con.close();
				//				}
			} catch (Exception ee){
				System.out.println("* Erro EnderecoDAO:62");
			}

		}
		return null;
	}
	
	public Endereco carregarEnderecoByIdProfessor(int id) {
		ResultSet rs;
		int retorno = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();

			stmt = con.prepareStatement(SQL_LER_ENDERECO_PROFESSOR);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt(1));
				endereco.setRua(rs.getString(2));
				endereco.setCasa(rs.getString(3));
				endereco.setCidade(rs.getString(4));

				return endereco;
			} else {
				return null;
			}
		} catch (Exception e){
			System.out.println("* Erro EnderecoDAO:51");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
				//				if(con != null) {
				//					con.close();
				//				}
			} catch (Exception ee){
				System.out.println("* Erro EnderecoDAO:62");
			}

		}
		return null;
	}
	
	public List<Endereco> listar(){
		int id = -1;
		List<Endereco> listaEndereco = new ArrayList<>();
		int retorno = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			stmt = con.prepareStatement(SQL_LISTAR_ENDERECO);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Endereco endereco = new Endereco();
				endereco.setId(rs.getInt(1));
				endereco.setRua(rs.getString(2));
				endereco.setCasa(rs.getString(3));
				endereco.setCidade(rs.getString(4));
				endereco.setCodAluno(rs.getInt(5));
				endereco.setCodProfessor(rs.getInt(6));
			
				listaEndereco.add(endereco);
			}
		} catch (Exception e){
			System.out.println("* Erro EnderecoDAO:48");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
//				if(con != null) {
//					con.close();
//				}
			} catch (Exception ee){
				System.out.println("* Erro EnderecoDAO:59");
			}

		}
		return listaEndereco;
	}
	public boolean salvar(Endereco endereco) {

		int id = -1;
		ResultSet rs;
		int retorno = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			if (endereco.getId() == null) {
				stmt = con.prepareStatement(SQL_PROXIMO_ID);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
					stmt.close();
					stmt = con.prepareStatement(SQL_SALVAR_ENDERECO);
					stmt.setInt(1, id);
					stmt.setString(2,endereco.getRua());
					stmt.setString(3,endereco.getCasa());
					stmt.setString(4,endereco.getCidade());
					stmt.setInt(5, endereco.getCodAluno());
					stmt.setInt(6, endereco.getCodProfessor());
					retorno = stmt.executeUpdate();
					
				}
				return (retorno > 0);
			} else {
				stmt = con.prepareStatement(SQL_ATUALIZAR_ENDERECO);
				stmt.setString(1,endereco.getRua());
				stmt.setString(2,endereco.getCasa());
				stmt.setString(3,endereco.getCidade());
				stmt.setInt(4, endereco.getCodAluno());
				stmt.setInt(5, endereco.getCodProfessor());
				
				stmt.setInt(6, endereco.getId());
				retorno = stmt.executeUpdate();
				return (retorno > 0);
			}
			
		} catch (Exception e){
			System.out.println("* Erro EnderecoDAO:102");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
//				if(con != null) {
//					con.close();
//				}
			} catch (Exception ee){
				System.out.println("* Erro EnderecoDAO:113");
			}

		}
		return false;
	}

	public boolean deletar(Endereco endereco) {

		int id = 1;
		int rs;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			stmt = con.prepareStatement(SQL_DELETAR_ENDERECO);
			stmt.setInt(1, endereco.getId());
			rs = stmt.executeUpdate();
			return (rs > 0 );
		} catch (Exception e){
			System.out.println("* Erro EnderecoDAO:133");
			e.printStackTrace();
		} finally {
			try {
				if (stmt != null){
					stmt.close();
				}
//				if(con != null) {
//					con.close();
//				}
			} catch (Exception ee){
				System.out.println("* Erro EnderecoDAO:144");
			}

		}
		return false;
	}

}
