package br.edu.fapi.jogadorDAO.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    public static String url = "jdbc:mysql://localhost:3306/forca";
    //passando a url do meu banco,forca é o nome da database
    public static String usuario = "root";
    public static String senha = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, usuario, senha);
    }
}



