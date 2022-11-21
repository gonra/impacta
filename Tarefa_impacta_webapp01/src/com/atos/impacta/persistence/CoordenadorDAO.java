package com.atos.impacta.persistence;

import com.atos.impacta.model.Coordenador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoordenadorDAO {

    private final String SQL_PROXIMO_ID = "select max(id_coordenador)+1 as nextid from tbl_coordenador";

    private final String SQL_SALVAR_COORDENADOR = "insert into tbl_coordenador (id_coordenador,coo_nome,coo_cpf,coo_salario, coo_loja, coo_metaloja) values (?,?,?,?,?,?)";
    private final String SQL_LISTAR_COORDENADOR = "select id_coordenador,coo_nome,coo_cpf,coo_salario,coo_loja,coo_metaloja from tbl_coordenador";
    private final String SQL_LISTAR_COORDENADOR_BY_CPF = "select id_coordenador, coo_nome, coo_cpf, coo_salario, coo_loja, coo_metaloja from tbl_coordenador where coo_cpf=?";
    private final String SQL_DELETAR_COORDENADOR_BY_CPF = "delete from tbl_coordenador where coo_cpf=?";
    private final String SQL_UPDATE_COORDENADOR = "update tbl_coordenador set coo_nome=?, coo_cpf=?, coo_salario=?, coo_loja=?, coo_metaloja=? where id_coordenador = ?";

    public boolean salvar(Coordenador item){
        int id = 1;
        int rs = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            if ((item.getId() == null) || (item.getId() < 1)) {
                stmt = con.prepareStatement(SQL_PROXIMO_ID);
                ResultSet rs_id = stmt.executeQuery();
                if (rs_id.next()) {
                    id = rs_id.getInt(1);
                }
                stmt.close();

                stmt = con.prepareStatement(SQL_SALVAR_COORDENADOR);
                stmt.setInt(1,id);
                stmt.setString(2,item.getNome());
                stmt.setString(3,item.getCpf());
                stmt.setDouble(4,item.getSalario());
                stmt.setString(5,item.getLoja());
                stmt.setDouble(6,item.getMetaLoja());
                rs = stmt.executeUpdate();
            } else {
                stmt = con.prepareStatement(SQL_UPDATE_COORDENADOR);
                stmt.setString(1,item.getNome());
                stmt.setString(2,item.getCpf());
                stmt.setDouble(3,item.getSalario());
                stmt.setString(4,item.getLoja());
                stmt.setDouble(5,item.getMetaLoja());
                stmt.setInt(6,item.getId());
                rs = stmt.executeUpdate();
            }

        } catch (Exception e){
            System.out.println("* Erro CoordenadorDAO:48");
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
                System.out.println("* Erro CoordenadorDAO:59");
            }

        }

        return (rs > 0);
    }

    public List<Coordenador> listar(){
        List<Coordenador> listar = new ArrayList<>();
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_LISTAR_COORDENADOR);
            rs = stmt.executeQuery();
            while (rs.next()){
                Coordenador coordenador = new Coordenador();
                coordenador.setId(rs.getInt(1));
                coordenador.setNome(rs.getString(2));
                coordenador.setCpf(rs.getString(3));
                coordenador.setSalario(rs.getDouble(4));
                coordenador.setLoja(rs.getString(5));
                coordenador.setMetaLoja(rs.getDouble(6));
                listar.add(coordenador);
            }
        } catch (Exception e){
            System.out.println("* Erro CoordenadorDAO:87");
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
                System.out.println("* Erro CoordenadorDAO:98");
            }

        }

        return listar;
    }

    public Coordenador listarByCpf(String cpf){
        Coordenador coordenador = null;

        ResultSet rs = null;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_LISTAR_COORDENADOR_BY_CPF);
            stmt.setString(1,cpf);
            rs = stmt.executeQuery();
            if (rs.next()){
                coordenador = new Coordenador();
                coordenador.setId(rs.getInt(1));
                coordenador.setNome(rs.getString(2));
                coordenador.setCpf(rs.getString(3));
                coordenador.setSalario(rs.getDouble(4));
                coordenador.setLoja(rs.getString(5));
                coordenador.setMetaLoja(rs.getDouble(6));
            }
        } catch (Exception e){
            System.out.println("* Erro CoordenadorDAO:127");
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
                System.out.println("* Erro CoordenadorDAO:138");
            }

        }

        return coordenador;
    }

    public boolean deletarByCpf(String cpf) {
        int rs = 0;
        Connection con = null;
        PreparedStatement stmt = null;
        try {
            con = FabricaConexao.criaConexao();
            stmt = con.prepareStatement(SQL_DELETAR_COORDENADOR_BY_CPF);
            stmt.setString(1, cpf);
            rs = stmt.executeUpdate();

        } catch (Exception e) {
            System.out.println("* Erro CoordenadorDAO:157");
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception ee) {
                System.out.println("* Erro CoordenadorDAO:168");
            }

        }

        return (rs > 0);
    }
}
