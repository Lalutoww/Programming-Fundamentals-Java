import java.util.Scanner;

public class TextFilter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] bannedWords = sc.nextLine().split(", ");
        String text = sc.nextLine();

        for (String word : bannedWords) {
            text = text.replace(word, "*".repeat(word.length()));
        }

        System.out.println(text);
    }
}
