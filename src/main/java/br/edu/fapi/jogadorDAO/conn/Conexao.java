package br.edu.fapi.jogadorDAO.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexao {

    public static Connection getConnection() {

        String url = "jdbc:mysql://localhost:3306/forca";
        //passando a url do meu banco,forca é o nome da database
        String usuario = "root";
        String senha = "";
        Connection connection;

        try {
            //coloco na connection a conexao,passando url,usuario  e senha
            connection = DriverManager.getConnection(url, usuario, senha);
            System.out.println("Conectado com sucesso!!!");
            return connection;
        } catch (SQLException e) {
            System.out.println("Erro de conexão");
            e.printStackTrace();
        }
        return null;

    }

    public static void fecha(Connection connection) {
        try {
            if (connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fechaConexao(Connection connection, Statement statement) {
        fecha(connection);
        try {
            if (statement != null)
                statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
