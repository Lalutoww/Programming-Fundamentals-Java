import java.util.Scanner;

public class DigitsLettersSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String digits = getDigits(input);
        String letters = getLetters(input);
        String symbols = getSymbols(input);

        System.out.println(digits);
        System.out.println(letters);
        System.out.println(symbols);
    }

    private static String getDigits(String input) {
        StringBuilder digits = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                digits.append(input.charAt(i));
            }
        }
        return new String(digits);
    }

    private static String getLetters(String input) {
        StringBuilder letters = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i))) {
                letters.append(input.charAt(i));
            }
        }
        return new String(letters);
    }

    private static String getSymbols(String input) {
        StringBuilder symbols = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetterOrDigit(input.charAt(i))) {
                symbols.append(input.charAt(i));
            }
        }
        return new String(symbols);
    }
}
