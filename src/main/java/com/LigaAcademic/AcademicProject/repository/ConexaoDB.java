package com.LigaAcademic.AcademicProject.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexaoDB {

    public static final String Url = "jdbc:postgresql://localhost:5432/ligadb";
    public static final String User = "postgres";
    public static final String Passoword = "2001310post";

    public static Connection conectardb(){
        try{
            Connection conexao = DriverManager.getConnection(Url,User,Passoword);
            System.out.println("Conexão com Banco de Dados foi um sucesso!");
            return conexao;
        } catch (SQLException e) {
            System.out.println("Erro ao conectar o banco de dados");
            e.printStackTrace();
            return null;
        }
    }
}

