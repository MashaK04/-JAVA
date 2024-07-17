

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class API6_1 {
    private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
    private static final String CLIENT_SECRET = "PUBLIC_SECRET";
    private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";


    public static void main(String[] args) throws Exception {
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

        String fromLang = "ru";
        String toLang = "en";
        System.out.println("Введите текст который вы хотите перевести с русского на английский");
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();


        API6_1.translate(fromLang, toLang, text);
    }

    public static void translate(String fromLang, String toLang, String text) throws Exception {
        // TODO: Should have used a 3rd party library to make a JSON string from an object
        String jsonPayload = new StringBuilder()
                .append("{")
                .append("\"fromLang\":\"")
                .append(fromLang)
                .append("\",")
                .append("\"toLang\":\"")
                .append(toLang)
                .append("\",")
                .append("\"text\":\"")
                .append(text)
                .append("\"")
                .append("}")
                .toString();

        URL url = new URL(ENDPOINT);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
        conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
        conn.setRequestProperty("Content-Type", "application/json");

        OutputStream os = conn.getOutputStream();
        os.write(jsonPayload.getBytes());
        os.flush();
        os.close();

        int statusCode = conn.getResponseCode();
        //System.out.println("Status Code: " + statusCode);
        BufferedReader br = new BufferedReader(new InputStreamReader(
                (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream()
        ));
        String output;
        while ((output = br.readLine()) != null) {
            System.out.println(output);
        }
        conn.disconnect();
    }

}