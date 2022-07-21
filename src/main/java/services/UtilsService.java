package services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class UtilsService {

    private static final String UTILS_SERVICE_URL = "http://localhost:8080";
    private static final HttpClient client = HttpClient.newHttpClient();

    private static HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(UTILS_SERVICE_URL + "/id"))
            .GET()
            .build();

    public static int getId() throws IOException, InterruptedException {
        return Integer.parseInt(client.send(request, HttpResponse.BodyHandlers.ofString()).body());
    }

}
