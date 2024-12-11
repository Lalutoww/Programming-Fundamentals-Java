import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int number = input.nextInt();
        printTriangle(number);
    }

    public static void printLineOfNumbers(int number) {
        for (int i = 1; i <= number; i++) {
            System.out.print(i);
            if (i < number) {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

    public static void printTriangle(int number) {
        for (int i = 1; i <= number; i++) {
            printLineOfNumbers(i);
        }
        for (int i = number - 1; i > 0; i--) {
            printLineOfNumbers(i);
        }
    }
}
