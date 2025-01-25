import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder input = new StringBuilder(sc.nextLine());

        int power = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentCharacter = input.charAt(i);
            if (power > 0 && currentCharacter != '>') {
                input.deleteCharAt(i);
                power--;
                i--;
            } else if (input.charAt(i) == '>') {
                power += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
            }

        }
        System.out.println(input);
    }
}
