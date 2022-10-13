package com.atos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.atos.model.Aluno;
import com.atos.model.Endereco;

public class AlunoDao {

	private final String SQL_PROXIMO_ID = "select max(id)+1 as nextid from tbl_aluno";
	private final String SQL_LISTAR_ALUNO = "select * from tbl_aluno";
	private final String SQL_LER_ALUNO= "select * from tbl_aluno where id=?";
	private final String SQL_SALVAR_ALUNO= "insert into tbl_aluno (id,nome,cpf,turma,media) values(?,?,?,?,?)";
	private final String SQL_ATUALIZAR_ALUNO= "update tbl_aluno set nome=?,cpf=?,turma=?,media=? where id=?";
	private final String SQL_DELETAR_ALUNO= "delete from tbl_aluno where id=?";

	private DatabaseFactory factory;

	public AlunoDao() {
		factory = new DatabaseFactory();
	}

	public Aluno carregarAlunoById(int id) {
		ResultSet rs;
		int retorno = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();

			stmt = con.prepareStatement(SQL_LER_ALUNO);
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			if (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setCpf(rs.getString(3));
				aluno.setTurma(rs.getString(4));
				aluno.setMedia(rs.getDouble(5));

				return aluno;
			} else {
				return null;
			}
		} catch (Exception e){
			System.out.println("* Erro AlunoDAO:51");
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
				System.out.println("* Erro AlunoDAO:62");
			}

		}
		return null;
	}



	public List<Aluno> listar(){
		int id = -1;
		List<Aluno> listaAluno = new ArrayList<>();
		int retorno = -1;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			stmt = con.prepareStatement(SQL_LISTAR_ALUNO);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt(1));
				aluno.setNome(rs.getString(2));
				aluno.setCpf(rs.getString(3));
				aluno.setTurma(rs.getString(4));
				aluno.setMedia(rs.getDouble(5));
				Endereco endereco = new Endereco();
				aluno.setEndereco(endereco);
				listaAluno.add(aluno);
			}
		} catch (Exception e){
			System.out.println("* Erro AlunoDAO:93");
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
				System.out.println("* Erro AlunoDAO:104");
			}

		}
		return listaAluno;
	}
	
	public Integer salvar(Aluno aluno) {

		int id = -1;
		ResultSet rs;
		
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			if (aluno.getId() == null) {
				stmt = con.prepareStatement(SQL_PROXIMO_ID);
				rs = stmt.executeQuery();
				if (rs.next()) {
					id = rs.getInt(1);
					stmt.close();
					stmt = con.prepareStatement(SQL_SALVAR_ALUNO);
					stmt.setInt(1, id);
					stmt.setString(2,aluno.getNome());
					stmt.setString(3,aluno.getCpf());
					stmt.setString(4,aluno.getTurma());
					stmt.setDouble(5, aluno.getMedia());
					stmt.executeUpdate();

				}
				
			} else {
				id = aluno.getId();
				stmt = con.prepareStatement(SQL_ATUALIZAR_ALUNO);
				stmt.setString(1,aluno.getNome());
				stmt.setString(2,aluno.getCpf());
				stmt.setString(3,aluno.getTurma());
				stmt.setDouble(4, aluno.getMedia());
				stmt.setInt(5, aluno.getId());
				stmt.executeUpdate();
				
			}
			return id;
		} catch (Exception e){
			System.out.println("* Erro AlunoDAO:147");
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
				System.out.println("* Erro AlunoDAO:158");
			}

		}
		return id;
	}

	public boolean deletar(Aluno aluno) {

		int id = 1;
		int rs;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = factory.getConexao();
			stmt = con.prepareStatement(SQL_DELETAR_ALUNO);
			stmt.setInt(1, aluno.getId());
			rs = stmt.executeUpdate();
			return (rs > 0 );
		} catch (Exception e){
			System.out.println("* Erro AlunoDAO:178");
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
				System.out.println("* Erro AlunoDAO:189");
			}

		}
		return false;
	}

}
