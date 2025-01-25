import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (i == 0) {
                sb.append(currentCharacter);
                continue;
            }
            char previousCharacter = input.charAt(i - 1);
            if (previousCharacter != currentCharacter) {
                sb.append(currentCharacter);
            }
        }
        System.out.println(sb);
    }
}
