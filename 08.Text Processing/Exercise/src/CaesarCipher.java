import java.util.Scanner;

public class CaesarCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder text = new StringBuilder(sc.nextLine());
        for (int i = 0; i < text.length(); i++) {
            text.replace(i, i + 1, String.format("%c", text.charAt(i) + 3));
        }
        System.out.println(text);
    }
}
