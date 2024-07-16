import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class map22 {
    public static void main(String[] args) {
        String searchKey = "95f50b46-1bba-4914-acfb-c09fdfae6e20";

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите название здания:");
            String name = scanner.nextLine().replace(" ", "+");

            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(new URI("https://search-maps.yandex.ru/v1/?type=biz&lang=ru_RU&apikey=" + searchKey + "&text=" + name))
                        .GET()
                        .build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

                // Проверяем статус-код ответа
                if (response.statusCode() == 200) {
                    JSONObject jo = new JSONObject(response.body());
                    JSONArray ja = jo.getJSONArray("features");

                    System.out.println("График работы '" + name.replace("+", " ") + "':");

                    if (ja.length() == 0) {
                        System.out.println("404 not found");
                    } else {
                        int counter = 1;
                        for (Object o : ja) {
                            JSONObject properties = ((JSONObject) o).getJSONObject("properties").getJSONObject("CompanyMetaData");
                            String schedule = "неизвестно";
                            if (properties.has("Hours")) {
                                JSONObject hours = properties.getJSONObject("Hours");
                                schedule = hours.getString("text");
                            }
                            System.out.println(counter++ + ". По адресу: " + properties.getString("address") + " - " + schedule);
                        }
                    }
                } else {
                    System.out.println("Ошибка при выполнении запроса: " + response.statusCode());
                }
            } catch (URISyntaxException | IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}