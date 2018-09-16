package br.edu.fapi.model;

import java.util.Date;

public class Jogador {
    private int idJogador;
    private String nome;
    private String situacao;
    private String palavraJogo;
    private int numVidas;
    private java.util.Date inicioJogo;
    private java.util.Date fimJogo;

    public int getIdJogador() {
        return idJogador;
    }

    public void setIdJogador(int idJogador) {
        this.idJogador = idJogador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public String getPalavraJogo() {
        return palavraJogo;
    }

    public void setPalavraJogo(String palavraJogo) {
        this.palavraJogo = palavraJogo;
    }

    public int getNumVidas() {
        return numVidas;
    }

    public void setNumVidas(int numVidas) {
        this.numVidas = numVidas;
    }

    public Date getInicioJogo() {
        return inicioJogo;
    }

    public void setInicioJogo(Date inicioJogo) {
        this.inicioJogo = inicioJogo;
    }

    public Date getFimJogo() {
        return fimJogo;
    }

    public void setFimJogo(Date fimJogo) {
        this.fimJogo = fimJogo;
    }
}
