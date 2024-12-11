import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String operator = input.nextLine();
        int a = input.nextInt();
        int b = input.nextInt();

        calculateNumbers(operator, a, b);

    }

    public static void calculateNumbers(String operation, int number1, int number2) {
        switch (operation) {
            case "add" -> {
                System.out.println(number1 + number2);
            }
            case "subtract" -> {
                System.out.println(number1 - number2);
            }
            case "multiply" -> {
                System.out.println(number1 * number2);
            }
            case "divide" -> {
                if (number2 == 0) {
                    System.out.println("Division by 0 is not allowed!");
                } else {
                    System.out.println(number1 / number2);
                }
            }
            default -> {
                System.out.println("Invalid operation!");
            }
        }
    }
}
