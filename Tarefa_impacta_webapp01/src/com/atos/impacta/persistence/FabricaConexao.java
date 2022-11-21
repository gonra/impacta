package com.atos.impacta.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexao {

    private static final String dbUrl="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String dbUser="TAREFA";
    private static final String dbPass="TAREFA";

    public static Connection criaConexao() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection con=DriverManager.getConnection(dbUrl,dbUser,dbPass);
        if (con == null){
            System.out.println("Erro conexao DB");
        } else {
            System.out.println("Conexao DB com sucesso");
        }
        return con;
    }
}
