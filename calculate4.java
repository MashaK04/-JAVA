import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class calculate4 {
    public static void main(String[] args) {
        String inputFileName = "input.txt";
        String outputFileName = "output.txt";

        try {
            File inputFile = new File(inputFileName);
            Scanner scanner = new Scanner(inputFile);
            FileWriter writer = new FileWriter(outputFileName);

            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String result = processInput(input);
                writer.write(input + " = " + result + "\n");
            }

            scanner.close();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + inputFileName);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + outputFileName);
        }
    }

    private static String processInput(String input) {
        String[] parts = input.split(" ");

        if (parts.length != 3) {
            return "Invalid input format!";
        }

        String a = parts[0];
        String operation = parts[1];
        String b = parts[2];

        try {
            double num1 = Double.parseDouble(a);
            double num2 = Double.parseDouble(b);

            switch (operation) {
                case "+":
                    return String.valueOf(num1 + num2);
                case "-":
                    return String.valueOf(num1 - num2);
                case "*":
                    return String.valueOf(num1 * num2);
                case "/":
                    if (num2 == 0) {
                        return "Error! Division by zero";
                    }
                    return String.valueOf(num1 / num2);
                default:
                    return "Operation Error!";
            }
        } catch (NumberFormatException e) {
            return "Error! Not number";
        }
    }
}