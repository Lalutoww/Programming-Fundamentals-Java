import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] words = sc.nextLine().split("\\s+");

        for (String word : words) {
            System.out.print(repeat(word, word.length()));
        }

    }

    private static String repeat(String word, int repetitions) {
        char[] repeated = new char[word.length() * repetitions]; // depends on how long the word is
        for (int i = 0; i < repeated.length; i++) {
            repeated[i] = word.charAt(i % word.length());
        }

        return new String(repeated);
    }
}
