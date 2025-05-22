package repositorio;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import modelo.TipoCambio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    private static final String API_KEY = "8b01993b6b-ca9baf6b7d-swkpzm";

    public TipoCambio tipoDeMoneda() throws IOException, InterruptedException {
        URI link = URI.create("https://api.fastforex.io/fetch-all?api_key=" + API_KEY);
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(link)
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), TipoCambio.class);
        } catch (Exception e) {
            throw new RuntimeException("No se encontra la lista de las monedas");
        }
    }

    public double consultaBaseDeDato(String from, String to) {
        URI enlace = URI.create("https://api.fastforex.io/fetch-one?from=" + from + "&to=" + to + "&api_key=" + API_KEY);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(enlace)
                .build();
        try {
            HttpResponse<String> response = null;

            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject json = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject result = json.getAsJsonObject("result");
            return result.get(to).getAsDouble();

        } catch (Exception e) {
            throw new RuntimeException("No se encontró esa moneda.");
        }
            }

}
