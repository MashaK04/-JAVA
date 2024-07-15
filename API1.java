import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class API1 {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.print("Введите день (1-31): ");
            int day = Integer.parseInt(reader.readLine());

            System.out.print("Введите месяц (1-12): ");
            int month = Integer.parseInt(reader.readLine());

            if (day < 1 || day > 31 || month < 1 || month > 12) {
                System.out.println("Ошибка!");
            } else {
                URL url = new URL("http://numbersapi.com/" + month + "/" + day + "/date");
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");

                BufferedReader apiReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String fact = apiReader.readLine();
                System.out.println("Интересный факт:" + fact);

                apiReader.close();
                connection.disconnect();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}