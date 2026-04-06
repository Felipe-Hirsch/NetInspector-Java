package redes;

import java.net.*;
import java.io.IOException;

public class AnalisadorPortas {

    public static void executar(String dominio) {
        System.out.println("\n--- Analisando Camada de Transporte ---");
        System.out.println("Alvo: " + dominio);


        int[] portas = {80, 443, 21};

        for (int porta : portas) {
            testarPortaTCP(dominio, porta);
        }
    }

    private static void testarPortaTCP(String host, int porta) {
        try (Socket socket = new Socket()) {
            socket.connect(new InetSocketAddress(host, porta), 2000);
            System.out.println("Porta " + porta + ": aberta");
        } catch (IOException e) {
            System.out.println("Porta " + porta + ": fechada");
        }
    }
}
