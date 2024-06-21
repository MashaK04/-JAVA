import java.util.Scanner;

public class calculate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

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
                        return;
                    }
                    result = num1 / num2;
                    break;
                default:
                    System.out.println("Operation Error!");
                    return;
            }

            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println("Error! Not number");
        }
    }
}