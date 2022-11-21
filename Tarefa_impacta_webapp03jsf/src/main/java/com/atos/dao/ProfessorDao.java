package com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.atos.model.Professor;
import com.atos.model.Endereco;

public class ProfessorDao {

	private final String SQL_PROXIMO_ID = "select max(id)+1 as nextid from tbl_PROFESSOR";
	private final String SQL_LISTAR_PROFESSOR = "select * from tbl_PROFESSOR";
	private final String SQL_LER_PROFESSOR= "select * from tbl_PROFESSOR where id=?";
	private final String SQL_SALVAR_PROFESSOR= "insert into tbl_PROFESSOR (id,nome,cpf,disciplina,salario) values(?,?,?,?,?)";
	private final String SQL_ATUALIZAR_PROFESSOR= "update tbl_PROFESSOR set nome=?,cpf=?,disciplina=?,salario=? where id=?";
	private final String SQL_DELETAR_PROFESSOR= "delete from tbl_PROFESSOR where id=?";
	
	private DatabaseFactory factory;
	
	public ProfessorDao() {
		factory = new DatabaseFactory();
	}
	
	public Professor carregarProfessorById(int id) {
		return null;
	}
	
	
	public List<Professor> listar(){
		int id = -1;
		List<Professor> listaProfessor = new ArrayList<>();
		int retorno = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			stmt = con.prepareStatement(SQL_LISTAR_PROFESSOR);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getInt(1));
				professor.setNome(rs.getString(2));
				professor.setCpf(rs.getString(3));
				professor.setDisciplina(rs.getString(4));
				professor.setSalario(rs.getDouble(5));
				Endereco endereco = new Endereco();
				professor.setEndereco(endereco);
				listaProfessor.add(professor);
			}
		} catch (Exception e){
			System.out.println("* Erro ProfessorDAO:48");
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
				System.out.println("* Erro ProfessorDAO:59");
			}

		}
		return listaProfessor;
	}
	public Integer salvar(Professor professor) {

		int id = -1;
		ResultSet rs;
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			if (professor.getId() == null) {
				stmt = con.prepareStatement(SQL_PROXIMO_ID);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
					stmt.close();
					stmt = con.prepareStatement(SQL_SALVAR_PROFESSOR);
					stmt.setInt(1, id);
					stmt.setString(2,professor.getNome());
					stmt.setString(3,professor.getCpf());
					stmt.setString(4,professor.getDisciplina());
					stmt.setDouble(5, professor.getSalario());
					stmt.executeUpdate();
					
				}
				
			} else {
				id = professor.getId();
				stmt = con.prepareStatement(SQL_ATUALIZAR_PROFESSOR);
				stmt.setString(1,professor.getNome());
				stmt.setString(2,professor.getCpf());
				stmt.setString(3,professor.getDisciplina());
				stmt.setDouble(4,professor.getSalario());
				stmt.setInt(5,professor.getId());
				stmt.executeUpdate();
				
			}
			return id;
		} catch (Exception e){
			System.out.println("* Erro ProfessorDAO:102");
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
				System.out.println("* Erro ProfessorDAO:113");
			}

		}
		return id;
	}

	public boolean deletar(Professor professor) {

		int id = 1;
		int rs;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			stmt = con.prepareStatement(SQL_DELETAR_PROFESSOR);
			stmt.setInt(1, professor.getId());
			rs = stmt.executeUpdate();
			return (rs > 0 );
		} catch (Exception e){
			System.out.println("* Erro ProfessorDAO:133");
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
				System.out.println("* Erro ProfessorDAO:144");
			}

		}
		return false;
	}

}
