import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        Map<String, String> words = new LinkedHashMap<>();

        while (!word.equals("end")) {
            String reversedWord = getReverse(word);
            words.put(word, reversedWord);

            word = sc.nextLine();
        }

        words.forEach((k, v) -> {
            System.out.println(k + " = " + v);
        });
    }

    private static String getReverse(String word) {
        StringBuilder reversedWord = new StringBuilder();

        for (int i = word.length() - 1; i >= 0; i--) {
            reversedWord.append(word.charAt(i));
        }
        return new String(reversedWord);
    }
}
