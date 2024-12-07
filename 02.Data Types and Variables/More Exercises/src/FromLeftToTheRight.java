import java.util.Scanner;

public class FromLeftToTheRight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int lines = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < lines; i++) {
            String numbers = scanner.nextLine();
            long number1 = Long.parseLong(numbers.split(" ")[0]);
            long number2 = Long.parseLong(numbers.split(" ")[1]);

            long sum = 0;
            if (number1 > number2) {
                number1 = Math.abs(number1);
                while (number1 > 0) {
                    sum += number1 % 10;
                    number1 = number1 / 10;
                }
                ;
            } else {
                number2 = Math.abs(number2);
                while (number2 > 0) {
                    sum += number2 % 10;
                    number2 = number2 / 10;
                }
            }
            System.out.println(sum);
        }
    }
}
