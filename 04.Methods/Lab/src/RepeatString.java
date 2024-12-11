import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int repetitions = scanner.nextInt();

        String repeatedString = repeatString(s, repetitions);

        System.out.println(repeatedString);
    }

    public static String repeatString(String s, int repetitions) {
        String[] words = new String[repetitions];

        for (int i = 0; i < repetitions; i++) {
            words[i] = s;
        }

        return String.join("", words);
    }
}
