import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        String value1 = scanner.nextLine();
        String value2 = scanner.nextLine();

        getGreater(type, value1, value2);

    }

    private static void getGreater(String type, String value1, String value2) {
        switch (type) {
            case "int" -> {
                int num1 = Integer.parseInt(value1);
                int num2 = Integer.parseInt(value2);

                System.out.println(Math.max(num1, num2));

            }
            case "char" -> {
                char ch1 = value1.charAt(0);
                char ch2 = value2.charAt(0);

                if (ch1 > ch2) {
                    System.out.println(ch1);
                } else {
                    System.out.println(ch2);
                }
            }
            case "string" -> {
                if (value1.compareTo(value2) > 0) {
                    System.out.println(value1);
                } else {
                    System.out.println(value2);
                }
            }
            default -> {
                System.out.println("Invalid type!");
            }
        }
    }
}
