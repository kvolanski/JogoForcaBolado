package br.edu.fapi.jogadorDAO;

import br.edu.fapi.model.Jogador;

//interface que define os metodos de salvar em base de dados/arquivos.
public interface JogoDAO {
    int createJogoInf(Jogador jogador, String palavra);


}
