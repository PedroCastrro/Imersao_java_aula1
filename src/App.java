import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

import javax.print.event.PrintEvent;

public class App {
     public static void main(String[] args) throws Exception {
       
        //fazer uma lista com os top's 250 filmes
        String url = "https://api.mocki.io/v2/549a5d8b";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body(); 
        System.out.println(body);

        //extrair apenas os dados que intereçam 
        var parser = new jsonparsers();
        List<Map<String, String>> ListaDeFilmes = parser.parse(body);
        
        //exibir e manipular os dados
        for (Map < String, String> filme : ListaDeFilmes) {
            System.out.println(filme.get("title"));
            System.out.println(filme.get("year"));
            System.out.println(filme.get("imDbRating"));
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRatingCount"));
            System.out.println();
        }
    }
}
