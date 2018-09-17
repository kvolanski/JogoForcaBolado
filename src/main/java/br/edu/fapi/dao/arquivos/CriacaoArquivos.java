package br.edu.fapi.dao.arquivos;

import br.edu.fapi.dao.database.JogoDAO;
import br.edu.fapi.dao.database.impl.JogoDAOImpl;
import br.edu.fapi.model.Jogador;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Calendar;
import java.util.List;

public class CriacaoArquivos{

    public CriacaoArquivos(){
        Path path = Paths.get(System.getProperty("user.dir")).resolve("Relatorios");

//        Path path3 = Paths.get(System.getProperty("user.dir")).resolve("Relatorios").resolve("RelatorioVitorias.txt");
//        Path path4 = Paths.get(System.getProperty("user.dir")).resolve("Relatorios").resolve("RelatorioDerrotas.txt");
        try {
            Files.createDirectory(path);
        } catch (IOException e) {}
    }

    public void criaRelatorioGeral() throws Exception {
        JogoDAO jogoDAO = new JogoDAOImpl();
        Path path = Paths.get(System.getProperty("user.dir")).resolve("Relatorios").resolve("RelatorioGeral.txt");
        String sql = "SELECT * FROM jogador";
        List<Jogador> listaJogadores;
        listaJogadores = jogoDAO.retrieveListJogos(sql);
        String define = "C:\\Users\\FAPILAB105\\Documents\\jogoForcaBolado\\Relatorios\\RelatorioGeral.txt";

        relatorio(path, define, listaJogadores);
    }

    public void criaRelatorioVitoria() throws Exception {
        JogoDAO jogoDAO = new JogoDAOImpl();
        Path path = Paths.get(System.getProperty("user.dir")).resolve("Relatorios").resolve("RelatorioVitoria.txt");
        String sql = "SELECT * FROM jogador WHERE situacao = 'VITORIA'";
        List<Jogador> listaJogadores;
        listaJogadores = jogoDAO.retrieveListJogos(sql);
        String define = "C:\\Users\\FAPILAB105\\Documents\\jogoForcaBolado\\Relatorios\\RelatorioVitoria.txt";

        relatorio(path, define, listaJogadores);
    }

    public void criaRelatorioDerrota() throws Exception {
        JogoDAO jogoDAO = new JogoDAOImpl();
        Path path = Paths.get(System.getProperty("user.dir")).resolve("Relatorios").resolve("RelatorioDerrota.txt");
        String sql = "SELECT * FROM jogador WHERE situacao = 'DERROTA'";
        List<Jogador> listaJogadores;
        listaJogadores = jogoDAO.retrieveListJogos(sql);
        String define = "C:\\Users\\FAPILAB105\\Documents\\jogoForcaBolado\\Relatorios\\RelatorioDerrota.txt";

        relatorio(path, define, listaJogadores);
    }

    private void relatorio(Path path, String define, List<Jogador> listaJogadores) throws Exception{
        try {
            Files.deleteIfExists(path);
            Files.createFile(path);
        } catch (FileAlreadyExistsException e){
            System.out.println(e.getMessage());
        }

        try {
            FileWriter fileWriter = new FileWriter(define, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            for (Jogador jogadores : listaJogadores){
                printWriter.printf("Nome:" + jogadores.getNome() + "\r\n" +
                        "Dificuldade: " + jogadores.getDificuldade() + "\r\n" +
                        "Palavra: " + jogadores.getPalavraJogo() + "\r\n" +
                        "Resultado: " + jogadores.getSituacao() + "\r\n" +
                        "Data e Hora de Inicio: " + jogadores.getInicioJogo() + "\r\n" +
                        "Data e Hora de Fim: " + jogadores.getFimJogo()+ "\r\n\r\n");
            }
            printWriter.close();

            try {
                List<String> linhas = Files.readAllLines(Paths.get(define), StandardCharsets.ISO_8859_1);
                for (String linha : linhas) {
                    System.out.println(linha);
                }
            } catch (IOException e) {
                e.getMessage();
            }
        } catch (IOException e) {
            e.getMessage();
        }
    }
}
