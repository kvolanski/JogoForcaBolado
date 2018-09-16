package br.edu.fapi.menus;

import br.edu.fapi.jogo.Jogo;
import br.edu.fapi.model.Jogador;

import java.util.Date;
import java.util.Scanner;

public class MenuJogo {

    public static void menuJogo(Scanner scanner, Jogador jogador){
        System.out.println("Escolha a dificuldade");
        System.out.println("1- Facil: 7 Vidas");
        System.out.println("2- Medio: 5 Vidas");
        System.out.println("3- Dificil: 3 Vidas");
        String escolha = scanner.nextLine();

        switch (escolha){
            case "1":
                jogador.setNumVidas(7);
                Date date = new Date();
                jogador.setInicioJogo(date);
                Jogo jogo = new Jogo(scanner, jogador);
                break;
            case "2":
                jogador.setNumVidas(5);
                date = new Date();
                jogador.setInicioJogo(date);
                jogo = new Jogo(scanner, jogador);
                break;
            case "3":
                jogador.setNumVidas(3);
                date = new Date();
                jogador.setInicioJogo(date);
                jogo = new Jogo(scanner, jogador);
                break;
            default:
                System.out.println("Opcao invalida. Por favor digite novamente");
                break;
        }
    }

}
