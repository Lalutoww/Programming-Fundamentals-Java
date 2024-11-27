import java.util.Scanner;

public class Messages {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String message = "";

        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            int number = Integer.parseInt(input);
            int length = input.length();
            int digit = number % 10;
            int offset = (digit - 2) * 3;

            if (digit == 8 || digit == 9) {
                offset++;
            }

            if (digit == 0) {
                message += " ";
            } else {
                message += (char) (97 + offset + length - 1);
            }
        }
        System.out.println(message);
    }
}
