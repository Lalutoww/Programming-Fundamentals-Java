import java.util.Arrays;
import java.util.Scanner;

public class EvenOddSubtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int evenSum = 0;
        int oddSum = 0;

        int[] numbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenSum += numbers[i];
            } else {
                oddSum += numbers[i];
            }
        }

        System.out.println(evenSum - oddSum);
    }
}
