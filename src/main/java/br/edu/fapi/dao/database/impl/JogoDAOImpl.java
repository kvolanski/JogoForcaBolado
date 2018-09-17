package br.edu.fapi.dao.database.impl;

import br.edu.fapi.dao.conn.Conexao;
import br.edu.fapi.dao.database.JogoDAO;
import br.edu.fapi.model.Jogador;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JogoDAOImpl implements JogoDAO {

    //Salva o registro do jogo e do Jogador na base de dados.
    @Override
    public int createJogoInf(Jogador jogador) {
        try (Connection connection = Conexao.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO jogador(nome, dificuldade, numVidas, inicioJogo)" +
                    "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, jogador.getNome());
            preparedStatement.setString(2, jogador.getDificuldade());
            preparedStatement.setInt(3, jogador.getNumVidas());
            java.sql.Timestamp sqlDateIni = new java.sql.Timestamp(jogador.getInicioJogo().getTime());
            preparedStatement.setTimestamp(4, sqlDateIni);

            preparedStatement.executeUpdate();


            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            resultSet.next();
            int auto_id = resultSet.getInt(1);

            return auto_id;

        } catch (SQLException e) {
            System.out.println("Falha na conexao");
            System.out.println(e.getMessage());
        }

        return 0;
    }

    @Override
    public boolean updatePalavra(Jogador jogador, String palavra) {
        try (Connection connection = Conexao.getConnection()){
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM jogador WHERE idjogador = " + jogador.getIdJogador());

            if (resultSet.first()){
                resultSet.updateString("palavraJogo", palavra);
                resultSet.updateRow();
                return resultSet.rowUpdated();
            }

        } catch (SQLException e) {
            System.out.println("Falha na conexao");
            System.out.println(e.getMessage());
        }
        return false;
    }

    @Override
    public boolean updateFimDateSit(Jogador jogador) {
        try (Connection connection = Conexao.getConnection()){
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);

            ResultSet resultSet = statement.executeQuery("SELECT * FROM jogador WHERE idjogador = " + jogador.getIdJogador());

            if (resultSet.first()){
                resultSet.updateString("situacao", jogador.getSituacao());
                java.sql.Timestamp sqlDateFim = new java.sql.Timestamp(jogador.getFimJogo().getTime());
                resultSet.updateTimestamp("fimJogo", sqlDateFim);
                resultSet.updateRow();
                return resultSet.rowUpdated();
            }

        } catch (SQLException e) {
            System.out.println("Falha na conexao");
            System.out.println(e.getMessage());
        }
        return false;
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

