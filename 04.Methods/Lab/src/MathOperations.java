import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double a = Double.parseDouble(scanner.nextLine());
        char operator = scanner.nextLine().charAt(0);
        double b = Double.parseDouble(scanner.nextLine());

        double result = calculate(a, operator, b);

        //Format the number: if numbers after floating point are 0 they are not printed
        System.out.println(new DecimalFormat("0.##").format(result));
    }

    public static double calculate(double a, char operator, double b) {
        switch (operator) {
            case '+' -> {
                return a + b;
            }
            case '-' -> {
                return a - b;
            }
            case '*' -> {
                return a * b;
            }
            case '/' -> {
                if (b == 0) {
                    System.out.println("Division by 0 is not allowed!");
                    return 0;
                }

                return a / b;
            }
            default -> {
                System.out.println("Invalid operator");
                return 0;
            }
        }
    }
}
