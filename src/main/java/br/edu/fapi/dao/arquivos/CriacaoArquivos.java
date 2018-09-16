package br.edu.fapi.dao.arquivos;

import br.edu.fapi.dao.database.JogoDAO;
import br.edu.fapi.dao.database.impl.JogoDAOImpl;
import br.edu.fapi.model.Jogador;

import java.io.*;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CriacaoArquivos {

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
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(define));

            for (Jogador jogador : listaJogadores){
                objectOutputStream.writeObject(jogador);
            }
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(define));
            Object object;

            try {
                do {
                    object = objectInputStream.readObject();
                    System.out.println(((Jogador) object).toString());
                } while (true);
            } catch (EOFException e){}
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
