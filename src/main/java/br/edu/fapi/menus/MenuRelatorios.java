package br.edu.fapi.menus;

import br.edu.fapi.dao.arquivos.CriacaoArquivos;
import br.edu.fapi.model.Jogador;
import br.edu.fapi.operacoes.Operacoes;

import java.util.Scanner;

public class MenuRelatorios {

    public static void menuRelatorios(Scanner scanner, Jogador jogador) throws Exception {
        CriacaoArquivos criacaoArquivos = new CriacaoArquivos();
        Operacoes.limpaTela();
        System.out.println("Escolha uma opcao de relatorios");
        System.out.println("1- Gerar Relatorio Geral");
        System.out.println("2- Gerar Relatorio de Vitorias");
        System.out.println("3- Gerar Relatorio de Derrotas");
        String escolha = scanner.nextLine();
        //está como string porque caso o usurário digite uma letra qualquer,ele vai cair no default
        //se estiver como int e o usuário digitar uma letra,vai dar erro.

        switch (escolha){
            case "1":
                criacaoArquivos.criaRelatorioGeral();
                break;
            case "2":
                criacaoArquivos.criaRelatorioVitoria();
                break;
            case "3":
                criacaoArquivos.criaRelatorioDerrota();
                break;
            default:
                System.out.println("Opcao invalida. Por favor digite novamente");
                break;
        }
    }

}
