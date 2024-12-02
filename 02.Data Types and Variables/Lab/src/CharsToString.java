import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = sc.nextLine().charAt(0);
        char ch2 = sc.nextLine().charAt(0);
        char ch3 = sc.nextLine().charAt(0);

        System.out.printf("%s%s%s", ch, ch2, ch3);
    }
}
