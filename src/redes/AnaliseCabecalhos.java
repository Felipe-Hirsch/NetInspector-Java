package redes;


import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpHeaders;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;


public class AnaliseCabecalhos {


    public static void executar(String dominio) {
        String urlCompleta = dominio.startsWith("http") ? dominio : "https://" + dominio;


        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(urlCompleta))
                    .method("HEAD", HttpRequest.BodyPublishers.noBody())
                    .build();


            HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
            HttpHeaders headers = response.headers();


            System.out.println("\n--- RESULTADOS DA ANÁLISE HTTP ---");
            System.out.println("Alvo: " + urlCompleta);

            imprimir(headers, "Server");
            imprimir(headers, "Content-Type");
            imprimir(headers, "Content-Length");
            imprimir(headers, "Date");
            System.out.println("----------------------------------\n");


        } catch (Exception e) {
            System.err.println("Erro na requisição: " + e.getMessage());
        }
    }


    private static void imprimir(HttpHeaders headers, String campo) {
        Optional<String> valor = headers.firstValue(campo);
        System.out.println("- " + campo + ": " + valor.orElse("Não informado pelo servidor"));
    }
}
