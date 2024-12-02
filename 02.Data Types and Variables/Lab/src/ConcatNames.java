import java.util.Scanner;

public class ConcatNames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String firstName = sc.nextLine();
        String lastName = sc.nextLine();
        String delimeter = sc.nextLine();

        System.out.printf("%s%s%s", firstName, delimeter, lastName);
    }
}
