package com.atos.impacta.persistence;

import com.atos.impacta.model.Dependente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DependenteDAO {
    private final String SQL_PROXIMO_ID = "select max(id_dependente)+1 as nextid from tbl_dependente";

    private final String SQL_SALVAR_DEPENDENTE = "insert into tbl_dependente (id_dependente,dep_nome,dep_idade,dep_vinculo,cod_funcionario,cod_tipo_funcionario) values (?,?,?,?,?,?)";
    private final String SQL_LISTAR_DEPENDENTE = "select id_dependente,dep_nome,dep_idade,dep_vinculo,cod_funcionario,cod_tipo_funcionario from tbl_dependente";
    private final String SQL_LISTAR_DEPENDENTE_BY_ID = "select  id_dependente,dep_nome,dep_idade,dep_vinculo,cod_funcionario,cod_tipo_funcionario from tbl_dependente where id_dependente=?";
    private final String SQL_DELETAR_DEPENDENTE_BY_ID = "delete from tbl_dependente where id_dependente=?";
    private final String SQL_UPDATE_DEPENDENTE = "update tbl_dependente set ger_nome=?, ger_cpf=? , ger_salario=?, ger_regional=?, ger_metaregional=? where id_gerente = ?";

    public boolean salvar(Dependente item){
        int id = 1;
        int rs = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();

            stmt = con.prepareStatement(SQL_PROXIMO_ID);
            ResultSet rs_id = stmt.executeQuery();
            if (rs_id.next()){
                id = rs_id.getInt(1);
            }
            stmt.close();

            stmt = con.prepareStatement(SQL_SALVAR_DEPENDENTE);
            stmt.setInt(1,id);
            stmt.setString(2,item.getNome());
            stmt.setInt(3,item.getIdade());
            stmt.setString(4,item.getVinculo());
            stmt.setInt(5,item.getCod_funcionario());
            stmt.setString(6,item.getCod_tipo_funcionario());

            rs = stmt.executeUpdate();

            
        } catch (Exception e){
            System.out.println("* Erro DependenteDAO:48");
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
                System.out.println("* Erro DependenteDAO:59");
            }

        }

        return (rs > 0);
    }

    public List<Dependente> listar(){
        List<Dependente> lista = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_LISTAR_DEPENDENTE);
            rs = stmt.executeQuery();
            while (rs.next()){
                Dependente item = new Dependente();
                item.setId(rs.getInt(1));
                item.setNome(rs.getString(2));
                item.setIdade(rs.getInt(3));
                item.setVinculo(rs.getString(4));
                item.setCod_funcionario(rs.getInt(5));
                item.setCod_tipo_funcionario(rs.getString(6));
                lista.add(item);
            }
        } catch (Exception e){
            System.out.println("* Erro DependenteDAO:87");
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
                System.out.println("* Erro DependenteDAO:98");
            }

        }

        return lista;
    }

    public Dependente listarById(int id){
        Dependente dependente = null;

        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_LISTAR_DEPENDENTE_BY_ID);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();
            if (rs.next()){
                dependente = new Dependente();
                dependente.setId(rs.getInt(1));
                dependente.setNome(rs.getString(2));
                dependente.setIdade(rs.getInt(3));
                dependente.setVinculo(rs.getString(4));
                dependente.setCod_funcionario(rs.getInt(5));
                dependente.setCod_tipo_funcionario(rs.getString(6));
            }
        } catch (Exception e){
            System.out.println("* Erro DependenteDAO:127");
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
                System.out.println("* Erro DependenteDAO:138");
            }

        }

        return dependente;
    }

    public boolean deletarDependente(Integer id){
        int rs = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_DELETAR_DEPENDENTE_BY_ID);
            stmt.setInt(1,id);
            rs = stmt.executeUpdate();

        } catch (Exception e){
            System.out.println("* Erro DependenteDAO:157");
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
                System.out.println("* Erro DependenteDAO:168");
            }

        }

        return (rs > 0);
    }

    public boolean atualizarGerente(Dependente item){

        int rs = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();

            stmt = con.prepareStatement(SQL_UPDATE_DEPENDENTE);
            stmt.setString(1,item.getNome());
            stmt.setInt(2,item.getIdade());
            stmt.setString(3,item.getVinculo());
            stmt.setInt(4,item.getCod_funcionario());
            stmt.setString(5,item.getCod_tipo_funcionario());
            stmt.setInt(6,item.getId());
            rs = stmt.executeUpdate();

        } catch (Exception e){
            System.out.println("* Erro DependenteDAO:194");
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
                System.out.println("* Erro DependenteDAO:205");
            }

        }

        return (rs > 0);
    }


}
