import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class calculate3 {
    public static void main(String[] args) {
        String input = readInputFromFile("input.txt");

        if (input == null || input.isEmpty()) {
            System.out.println("Empty input or file not found!");
            return;
        }

        String[] parts = input.split(" ");

        if (parts.length != 3) {
            System.out.println("Invalid input format!");
            return;
        }

        String a = parts[0];
        String operation = parts[1];
        String b = parts[2];

        try {
            double num1 = Double.parseDouble(a);
            double num2 = Double.parseDouble(b);

            double result;

            switch (operation) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 == 0) {
                        System.out.println("Error! Division by zero");
                        writeOutputToFile("output.txt", "Error! Division by zero");
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Operation Error!");
                    writeOutputToFile("output.txt", "Operation Error!");
                    return;
            }

            System.out.println(result);
            writeOutputToFile("output.txt", String.valueOf(result));
        } catch (NumberFormatException e) {
            System.out.println("Error! Not number");
            writeOutputToFile("output.txt", "Error! Not number");
        }
    }

    private static String readInputFromFile(String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            if (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                scanner.close();
                return input;
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        }

        return null;
    }

    private static void writeOutputToFile(String fileName, String output) {
        try {
            FileWriter writer = new FileWriter(fileName);
            writer.write(output);
            writer.close();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + fileName);
        }
    }
}