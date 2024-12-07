import java.util.Scanner;

public class PrintNumbersInReverse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int[] numbers = new int[n];

        for (int i = 0; i < n; i++) {
            numbers[i] = input.nextInt();
        }

        for (int j = numbers.length - 1; j >= 0; j--) {
            System.out.print(numbers[j] + " ");
        }

    }
}
