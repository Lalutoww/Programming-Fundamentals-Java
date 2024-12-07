import java.util.Scanner;

public class FloatingEquality {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final double EPSILON = 0.000001;

        double a = Double.parseDouble(scanner.nextLine());
        double b = Double.parseDouble(scanner.nextLine());


        if (Math.abs(a - b) < EPSILON) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }

    }
}
