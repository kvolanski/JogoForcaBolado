package br.edu.fapi.dao.arquivos;

import br.edu.fapi.dao.database.JogoDAO;
import br.edu.fapi.dao.database.impl.JogoDAOImpl;
import br.edu.fapi.model.Jogador;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class CriacaoArquivos {

    public CriacaoArquivos(){
        Path path = Paths.get(System.getProperty("user.dir")).resolve("Relatorios");
        try {
            Files.createDirectory(path);
        } catch (IOException e) {}
    }

    public static void criaRelatorioGeral() throws Exception{
        JogoDAO jogoDAO = new JogoDAOImpl();
        String sql = "SELECT * FROM jogador";
        List<Jogador> listaJogadores;
        listaJogadores = jogoDAO.retrieveListJogos(sql);

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("RelatorioGeral.txt"));

            for (Jogador jogador : listaJogadores){
                objectOutputStream.writeObject(jogador);
            }
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("RelatorioGeral.txt"));
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
