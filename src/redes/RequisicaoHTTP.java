package redes;


import java.io.*;
import java.net.*;


public class RequisicaoHTTP {


    public static void executar(String dominio) {
        System.out.println("\n--- Realizando Requisição HTTP Manual ---");


        int porta = 80;


        try (Socket socket = new Socket(dominio, porta)) {


            socket.setSoTimeout(5000);


            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);


            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));


            out.print("GET / HTTP/1.1\r\n");
            out.print("Host: " + dominio + "\r\n");
            out.print("Connection: close\r\n");
            out.print("\r\n");
            out.flush();


            String linha;
            boolean primeiraLinha = true;


            System.out.println("Resultados extraídos:");


            while ((linha = in.readLine()) != null) {


                if (primeiraLinha) {
                    System.out.println("HTTP Status: " + linha);
                    primeiraLinha = false;
                }


                if (linha.startsWith("Server:")) {
                    System.out.println("Servidor: " + linha.replace("Server:", "").trim());
                }
                if (linha.startsWith("Content-Length:")) {
                    System.out.println("Content-Length: " + linha.replace("Content-Length:", "").trim());
                }
                if (linha.isEmpty()) {
                    break;
                }
            }


        } catch (UnknownHostException e) {
            System.err.println("Erro: Não foi possível encontrar o host " + dominio);
        } catch (IOException e) {
            System.err.println("Erro de I/O: " + e.getMessage());
        }
    }
}
