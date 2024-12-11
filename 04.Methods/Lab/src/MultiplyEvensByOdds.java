import java.util.Arrays;
import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String lineOfNumbers = scanner.nextLine();

        int result = getMultiplicationOfEvenAndOdd(lineOfNumbers);

        System.out.println(result);
    }

    public static int getMultiplicationOfEvenAndOdd(String lineOfNumbers) {
        if (lineOfNumbers.charAt(0) == '-') {
            lineOfNumbers = lineOfNumbers.substring(1);
        }
        int[] arrayOfNumbers = Arrays.stream(lineOfNumbers.split("")).mapToInt(Integer::parseInt).toArray();
        int evenSum = 0;
        int oddSum = 0;

        for (int number : arrayOfNumbers) {
            if (number % 2 == 0) {
                evenSum += Math.abs(number);
            } else {
                oddSum += Math.abs(number);
            }
        }

        return evenSum * oddSum;
    }
}
