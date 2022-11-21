package com.atos.impacta.persistence;

import com.atos.impacta.model.Gerente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class GerenteDAO
{
    private final String SQL_PROXIMO_ID = "select max(id_gerente)+1 as nextid from tbl_gerente";

    private final String SQL_SALVAR_GERENTE = "insert into tbl_gerente (id_gerente,ger_nome,ger_cpf,ger_salario, ger_regional, ger_metaregional) values (?,?,?,?,?,?)";
    private final String SQL_LISTAR_GERENTE = "select id_gerente,ger_nome,ger_cpf,ger_salario,ger_regional,ger_metaregional from tbl_gerente";
    private final String SQL_LISTAR_GERENTE_BY_CPF = "select id_gerente, ger_nome, ger_cpf, ger_salario, ger_regional, ger_metaregional from tbl_gerente where ger_cpf=?";
    private final String SQL_DELETAR_GERENTE_BY_CPF = "delete from tbl_gerente where ger_cpf=?";
    private final String SQL_UPDATE_GERENTE = "update tbl_gerente set ger_nome=?, ger_cpf=?, ger_salario=?, ger_regional=?, ger_metaregional=? where id_gerente = ?";

    public boolean salvarGerente(Gerente item){
        int id = 1;
        int rs = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            if (item.getId() == null) {
                stmt = con.prepareStatement(SQL_PROXIMO_ID);
                ResultSet rs_id = stmt.executeQuery();
                if (rs_id.next()) {
                    id = rs_id.getInt(1);
                }
                stmt.close();

                stmt = con.prepareStatement(SQL_SALVAR_GERENTE);
                stmt.setInt(1,id);
                stmt.setString(2,item.getNome());
                stmt.setString(3,item.getCpf());
                stmt.setDouble(4,item.getSalario());
                stmt.setString(5,item.getRegional());
                stmt.setDouble(6,item.getMetaRegional());
                rs = stmt.executeUpdate();
            } else {
                stmt = con.prepareStatement(SQL_UPDATE_GERENTE);
                stmt.setString(1,item.getNome());
                stmt.setString(2,item.getCpf());
                stmt.setDouble(3,item.getSalario());
                stmt.setString(4,item.getRegional());
                stmt.setDouble(5,item.getMetaRegional());
                stmt.setInt(6,item.getId());
                rs = stmt.executeUpdate();
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

        return (rs > 0);
    }

    public List<Gerente> listar(){
        List<Gerente> listaGerente = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_LISTAR_GERENTE);
            rs = stmt.executeQuery();
            while (rs.next()){
                Gerente gerente = new Gerente();
                gerente.setId(rs.getInt(1));
                gerente.setNome(rs.getString(2));
                gerente.setCpf(rs.getString(3));
                gerente.setSalario(rs.getDouble(4));
                gerente.setRegional(rs.getString(5));
                gerente.setMetaRegional(rs.getDouble(6));
                listaGerente.add(gerente);
            }
        } catch (Exception e){
            System.out.println("* Erro GerenteDAO:87");
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
                System.out.println("* Erro GerenteDAO:98");
            }

        }

        return listaGerente;
    }

    public Gerente listarByCpf(String cpf){
        Gerente gerente = null;

        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_LISTAR_GERENTE_BY_CPF);
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();
            if (rs.next()){
                gerente = new Gerente();
                gerente.setId(rs.getInt(1));
                gerente.setNome(rs.getString(2));
                gerente.setCpf(rs.getString(3));
                gerente.setSalario(rs.getDouble(4));
                gerente.setRegional(rs.getString(5));
                gerente.setMetaRegional(rs.getDouble(6));
            }
        } catch (Exception e){
            System.out.println("* Erro GerenteDAO:127");
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
                System.out.println("* Erro GerenteDAO:138");
            }

        }

        return gerente;
    }

    public boolean deletarGerente(String cpf){
        int rs = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_DELETAR_GERENTE_BY_CPF);
            stmt.setString(1,cpf);
            rs = stmt.executeUpdate();

        } catch (Exception e){
            System.out.println("* Erro GerenteDAO:157");
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
                System.out.println("* Erro GerenteDAO:168");
            }
        }

        return (rs > 0);
    }

}
