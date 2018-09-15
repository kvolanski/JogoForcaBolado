package br.edu.fapi.jogadorDAO.impl;

import br.edu.fapi.jogadorDAO.JogoDAO;
import br.edu.fapi.jogadorDAO.conn.Conexao;
import br.edu.fapi.model.Jogador;

import java.sql.*;

public class JogoDAOImpl implements JogoDAO {

    @Override
    public int createJogoInf(Jogador jogador) {
        try (Connection connection = Conexao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jogador(nome, situacao, numVidas, inicioJogo, fimJogo)" +
                    "VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, jogador.getNome());
            preparedStatement.setString(2, jogador.getSituacao());
            preparedStatement.setInt(3, jogador.getNumVidas());
            java.sql.Timestamp sqlDateIni = new java.sql.Timestamp(jogador.getInicioJogo().getTime());
            preparedStatement.setTimestamp(4, sqlDateIni);
            java.sql.Timestamp sqlDateFim = new java.sql.Timestamp(jogador.getFimJogo().getTime());
            preparedStatement.setTimestamp(5, sqlDateFim);

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

