import java.util.Scanner;

public class LowerOrUpper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char ch = sc.next().charAt(0);

        if (ch == Character.toUpperCase(ch)) {
            System.out.println("upper-case");
        } else {
            System.out.println("lower-case");
        }
    }
}
