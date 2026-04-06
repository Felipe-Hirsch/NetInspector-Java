package redes;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = -1;

        do {
            System.out.println("\n=====================================");
            System.out.println("           NETINSPECTOR              ");
            System.out.println("=====================================");
            System.out.print("Digite o domínio para análise (ex: google.com): ");
            String dominio = scanner.next();
            System.out.println("\nEscolha a operação desejada:");
            System.out.println("1) Resolução DNS");
            System.out.println("2) Análise de Camada de Transporte (TCP)");
            System.out.println("3) Requisição HTTP Manual");
            System.out.println("4) Análise de Cabeçalhos HTTP");
            System.out.println("0) Sair");
            System.out.print("\nOpção: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Chamando Resolução DNS...");
                    ResolucaoDNS.executar(dominio);
                    break;
                case 2:
                    System.out.println("Chamando Analise da Camada de Transporte (TCP)...");
                    AnalisadorPortas.executar(dominio);
                    break;
                case 3:
                    System.out.println("Chamando Requisição HTTP Manual...");
                    RequisicaoHTTP.executar(dominio);
                    break;
                case 4:
                    System.out.println("Chamando Análise de Cabeçalhos...");
                    AnaliseCabecalhos.executar(dominio);
                    break;
                case 0:
                    System.out.println("Encerrando NetInspector. Até logo!");
                    break;
                default:
                    System.out.println("Erro: Opção inválida!");
                    break;
            }
        } while (opcao != 0);
        scanner.close();
    }
}
