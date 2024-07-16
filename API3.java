import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

import org.json.*;

public class API3 {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ответьте на 8 вопросов викторины");
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("http://jservice.io/api/random?count=8")).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String jsonString = response.body();

        System.out.println("Ответ от сервера: " + jsonString);

        JSONObject jsonObject = new JSONObject(jsonString);
        int counter = 0;
        JSONArray array = jsonObject.getJSONArray("results");
        for (int i = 0; i < array.length(); i++){
            JSONObject obj = array.getJSONObject(i);
            String answer = obj.getString("answer");
            String question = obj.getString("question");
            System.out.println("Question " + (i + 1) + ": " +  question + "?" + answer);
            String choice = scanner.nextLine();
            if (choice.equalsIgnoreCase(answer)) counter++;
        }
        System.out.println("Вы ответили верно на " + counter + " из 8 вопросов");
    }
}