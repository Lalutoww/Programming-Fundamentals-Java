import java.util.Scanner;

public class DataTypes {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String value = input.nextLine();

        printValue(value, input);
    }

    public static void printValue(String value, Scanner input) {
        switch (value) {
            case "int" -> {
                int number = input.nextInt();
                System.out.println(number * 2);
            }
            case "real" -> {
                double number = input.nextDouble();
                System.out.printf("%.2f", number * 1.5);
            }
            case "string" -> {
                String string = input.nextLine();
                System.out.printf("$%s$", string);
            }
            default -> {
                System.out.println("Invalid data type!");
            }

        }
    }
}
