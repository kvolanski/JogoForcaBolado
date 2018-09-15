package br.edu.fapi.jogadorDAO.impl;

import br.edu.fapi.jogadorDAO.JogoDAO;
import br.edu.fapi.jogadorDAO.conn.Conexao;
import br.edu.fapi.model.Jogador;

import java.sql.*;

public class JogoDAOImpl implements JogoDAO {

    //Salva o registro do jogo do Jogador na base de dados.
    @Override
    public int createJogoInf(Jogador jogador, String palavra) {
        try (Connection connection = Conexao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jogador(nome, situacao, palavraJogo, numVidas, inicioJogo, fimJogo)" +
                    "VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, jogador.getNome());
            preparedStatement.setString(2, jogador.getSituacao());
            preparedStatement.setString(3, palavra);
            preparedStatement.setInt(4, jogador.getNumVidas());
            java.sql.Timestamp sqlDateIni = new java.sql.Timestamp(jogador.getInicioJogo().getTime());
            preparedStatement.setTimestamp(5, sqlDateIni);
            java.sql.Timestamp sqlDateFim = new java.sql.Timestamp(jogador.getFimJogo().getTime());
            preparedStatement.setTimestamp(6, sqlDateFim);

            int resultado = preparedStatement.executeUpdate();
            ResultSet res = preparedStatement.getGeneratedKeys();

            return resultado;

        } catch (SQLException e) {
            System.out.println("Falha na conexao");
            System.out.println(e.getMessage());
        }

        return 0;
    }
}

