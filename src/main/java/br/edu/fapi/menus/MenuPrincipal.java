package br.edu.fapi.menus;

import br.edu.fapi.model.Jogador;
import br.edu.fapi.operacoes.Operacoes;

import java.util.Scanner;

public class MenuPrincipal {

    public MenuPrincipal() throws Exception {
        Jogador jogador = new Jogador();
        Scanner scanner = new Scanner(System.in);
        boolean continua = true;

        System.out.println("Ola!! Bem vindo ao jogo da forca!!");
        System.out.println("Brought to you by DKRT Team");
        System.out.println();
        System.out.println();
        System.out.println("Por favor, digite seu nome.");

        do {
            jogador.setNome(scanner.nextLine());

            if (jogador.getNome().length() <= 0){
                System.out.println("Por favor, digite seu nome.");
            }

        }while (jogador.getNome().length() <= 0);



        while (continua) {
            System.out.println();
            System.out.println("Escolha uma opcao");
            System.out.println("1- Jogar");
            System.out.println("2- Gerar Relatorios");
            System.out.println("0- sair");
            String escolha = scanner.nextLine();
            //está como string porque caso o usurário digite uma letra qualquer,ele vai cair no default
            //se estiver como int e o usuário digitar uma letra,vai dar erro.

            switch (escolha) {
                case "1":
                    MenuJogo.menuJogo(scanner, jogador);
                    break;
                case "2":
                    MenuRelatorios.menuRelatorios(scanner, jogador);
                    break;
                case "0":
                    Operacoes.limpaTela();
                    System.out.println("Muito obrigado por jogar nosso jogo!! ^^");
                    System.out.println("    Te esperamos pra uma proxima!!");
                    System.out.println();
                    System.out.println();
                    System.out.println("           Dev team:         ");
                    System.out.println("              D          iego");
                    System.out.println("              K          evin");
                    System.out.println("              R          obson");
                    System.out.println("              T          iago ");
                    continua = false;
                    break;
                default:
                    System.out.println("Opcao invalida. Por favor digite novamente");
            }
        }

    }

}
