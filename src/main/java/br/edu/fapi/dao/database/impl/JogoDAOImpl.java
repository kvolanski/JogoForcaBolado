package br.edu.fapi.dao.database.impl;

import br.edu.fapi.dao.database.JogoDAO;
import br.edu.fapi.dao.conn.Conexao;
import br.edu.fapi.model.Jogador;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class JogoDAOImpl implements JogoDAO {

    //Salva o registro do jogo e do Jogador na base de dados.
    @Override
    public int createJogoInf(Jogador jogador, String palavra) {
        try (Connection connection = Conexao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jogador(nome, dificuldade, situacao, palavraJogo, numVidas, inicioJogo, fimJogo)" +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, jogador.getNome());
            preparedStatement.setString(2, jogador.getDificuldade());
            preparedStatement.setString(3, jogador.getSituacao());
            preparedStatement.setString(4, palavra);
            preparedStatement.setInt(5, jogador.getNumVidas());
            java.sql.Timestamp sqlDateIni = new java.sql.Timestamp(jogador.getInicioJogo().getTime());
            preparedStatement.setTimestamp(6, sqlDateIni);
            java.sql.Timestamp sqlDateFim = new java.sql.Timestamp(jogador.getFimJogo().getTime());
            preparedStatement.setTimestamp(7, sqlDateFim);

            int resultado = preparedStatement.executeUpdate();

            return resultado;

        } catch (SQLException e) {
            System.out.println("Falha na conexao");
            System.out.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public List<Jogador> retrieveListJogos(String sql) {
        List<Jogador> listaJogadores = new ArrayList<>();

        try (Connection connection = Conexao.getConnection()){
            PreparedStatement preparedStatement = connection.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()){
                Jogador jogador = new Jogador();
                jogador.setIdJogador(resultSet.getInt("idjogador"));
                jogador.setNome(resultSet.getString("nome"));
                jogador.setDificuldade(resultSet.getString("dificuldade"));
                jogador.setSituacao(resultSet.getString("situacao"));
                jogador.setPalavraJogo(resultSet.getString("palavraJogo"));
                jogador.setNumVidas(resultSet.getInt("numVidas"));
                jogador.setInicioJogo(resultSet.getTimestamp("inicioJogo"));
                jogador.setFimJogo(resultSet.getTimestamp("fimJogo"));
                listaJogadores.add(jogador);
            }

            return listaJogadores;

        } catch (SQLException e) {
            System.out.println("Falha na conexao");
            System.out.println(e.getMessage());
        }

        return listaJogadores;
    }
}

