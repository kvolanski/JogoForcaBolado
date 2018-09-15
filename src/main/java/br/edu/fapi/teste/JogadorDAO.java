package br.edu.fapi.teste;

import br.edu.fapi.jogadorDAO.conn.Conexao;
import br.edu.fapi.model.Jogador;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class JogadorDAO {

    public void save(){
        String sql = "INSERT INTO `jogador` (`idjogador`, `nome`, `situacao`, `numVidas`, `inicioJogo`, `fimJogo`) " +
                "VALUES (NULL, 'Kevin', 'MESTRE', '5', '2018-09-12 00:00:00', '2018-09-21 00:00:00');";
        Connection connection = Conexao.getConnection();

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
            System.out.println("Atualizado com sucesso!!");

            Conexao.fechaConexao(connection,statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
