import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) throws Exception {
        
        //fazer uma conexão HTTP e buscar os top 250 filmes do IMDB
        String url = "https://imdb-api.com/en/API/Top250Movies/k_14ky5l7t";

        URI endereco = URI.create(url);

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder(endereco).GET().build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        String body = response.body();

        //System.out.println(body);
        
        //extrair só os dados que interessam(título, poster, classificação)
        JsonParser parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        var gerador = new GeradorStickers();
        //exivbir e manipular dados
        for (Map<String, String> filme : listaDeFilmes){

            String titulo = filme.get("title");
            String urlImagem = filme.get("image");
            InputStream inputStream = new URL(urlImagem).openStream();
            String nomeArquivo = titulo + ".png";

            gerador.gerarStickers(inputStream, nomeArquivo);
            System.out.println(nomeArquivo);
            // System.out.println(filme.get("title"));
            // System.out.println(filme.get("image"));
            // System.out.println(filme.get("imDbRating"));
            System.out.println();
        }
        //exibir e manipular dados
    }
}
