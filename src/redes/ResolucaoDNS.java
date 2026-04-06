package redes;
import java.net.*;
public class ResolucaoDNS {
    public static void executar(String dominio) {
        try {
            long inicio = System.currentTimeMillis();
            InetAddress[] enderecos = InetAddress.getAllByName(dominio);
            long tempo = System.currentTimeMillis() - inicio;
            System.out.println("\n------------- RESOLUÇÃO DNS -------------\n");
            for (InetAddress ip : enderecos) {
                String endereco = ip.getHostAddress();
                String tipo;
                if (ip instanceof Inet4Address) {
                    tipo = "A";
                } else {
                    tipo = "AAAA";
                }
                System.out.println("Domínio           : " + dominio);
                System.out.println("IP                : " + endereco);
                System.out.println("Tipo              : " + tipo);
                System.out.println("Tempo de resolução: " + tempo + " ms");
                System.out.println("-----------------------------------------");
            }
        } catch (UnknownHostException e) {
            System.out.println("Erro: Domínio não encontrado -> " + dominio);
        }
    }
}
