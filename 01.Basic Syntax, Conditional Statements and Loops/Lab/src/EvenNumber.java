import java.util.Scanner;

public class EvenNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        while (number % 2 != 0) {
            System.out.println("Please write an even number.");
            number = sc.nextInt();
        }

        System.out.printf("The number is: %d", Math.abs(number));
    }
}
