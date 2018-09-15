package br.edu.fapi.jogadorDAO.impl;

import br.edu.fapi.jogadorDAO.JogoDAO;
import br.edu.fapi.jogadorDAO.conn.Conexao;
import br.edu.fapi.model.Jogador;

import java.sql.*;

public class JogoDAOImpl implements JogoDAO {
    @Override
    public int createJogoInf(Jogador jogador) {
        Conexao conexao = new Conexao();


        try (Connection connection =  conexao.getConnection()
        ) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "insert into jogador(nome, situacao,numVidas, inicioJogo, fimJogo) values (?,?,?,?,?)",
                    Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1,jogador.getNome());
            preparedStatement.setString(2, jogador.getSituacao());
            preparedStatement.setInt(3, jogador.getNumVidas());
            preparedStatement.setDate(4, jogador.getInicioJogo());
            preparedStatement.setDate(5, jogador.getFimJogo());

            // INSERT, UPDATE OU DELETE (executeUpdate())
            // Resultado é um valor int que indica o número de linhas afetadas.
            int resultado = preparedStatement.executeUpdate();
            System.out.println("Registro inserido");
            //// Obtém a pk gerada.
            ResultSet res = preparedStatement.getGeneratedKeys();
            if (res.first()) {
                System.out.println("Código gerado: " + res.getInt(1));
            }
            return resultado;
        } catch (SQLException e) {
            System.out.println("Conexão não estabelecida.");
            System.out.println(e.getMessage());
        }

        return 0;
    }


}
