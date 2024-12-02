import java.util.Scanner;

public class ReversedChars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch1 = sc.nextLine().charAt(0);
        char ch2 = sc.nextLine().charAt(0);
        char ch3 = sc.nextLine().charAt(0);

        System.out.printf("%s %s %s", ch3, ch2, ch1);
    }
}
