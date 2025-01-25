import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] data = sc.nextLine().split("\\s+");
        double sum = 0;

        for (String currentString : data) {
            char firstLetter = currentString.charAt(0);
            char secondLetter = currentString.charAt(currentString.length() - 1);
            double number = Double.parseDouble(currentString.substring(1, currentString.length() - 1));

            int firstLetterPosition = getPositionInAlphabet(firstLetter);
            int secondLetterPosition = getPositionInAlphabet(secondLetter);

            if (Character.isUpperCase(firstLetter)) {
                number /= firstLetterPosition;
            } else {
                number *= firstLetterPosition;
            }

            if (Character.isUpperCase(secondLetter)) {
                number -= secondLetterPosition;
            } else {
                number += secondLetterPosition;
            }

            sum += number;
        }
        System.out.printf("%.2f", sum);
    }

    private static int getPositionInAlphabet(char letter) {
        return Character.toLowerCase(letter) - 96;
    }
}
