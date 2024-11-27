import java.util.Scanner;

public class SortNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int number3 = sc.nextInt();
        int temp;

        if (number1 > number2) {
            temp = number1;
            number1 = number2;
            number2 = temp;
        }
        if (number2 > number3) {
            temp = number2;
            number2 = number3;
            number3 = temp;
        }
        if (number1 > number2) {
            temp = number1;
            number1 = number2;
            number2 = temp;
        }

        System.out.println(number3);
        System.out.println(number2);
        System.out.println(number1);
    }
}
