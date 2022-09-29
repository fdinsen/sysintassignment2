package services;


import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CreateCamundaTaskService {
    private static final String _url = "localhost:8080/engine-rest/process-definition/key/handle-complaint/start";

    public static void CreateCamundaTask(String email, String content) throws IOException, URISyntaxException, InterruptedException {
        System.out.println("Ive been called.");
        String jsonInput = String.format("{\"variables\": {\"complaint\": {\"value\": \"%s\", type: \"String\"}, \"email\": {\"value\": \"%s\", type: \"String\"}}, \"businessKey\": \"javaemaillistener\"}", content, email);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(_url))
                .POST(HttpRequest.BodyPublishers.ofString(jsonInput))
                .build();
        HttpClient client = HttpClient.newHttpClient();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response);
    }
}
