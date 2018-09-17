package br.edu.fapi.dao.database;

import br.edu.fapi.model.Jogador;

import java.util.List;

public interface JogoDAO {
    //interface que define os metodos de salvar em base de dados/arquivos.

    int createJogoInf(Jogador jogador);

    boolean updatePalavra(Jogador jogador, String palavra);

    boolean updateFimDateSit(Jogador jogador);

    List<Jogador> retrieveListJogos(String sql);

}
