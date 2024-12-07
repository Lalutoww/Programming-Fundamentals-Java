import java.util.Scanner;

public class RecursiveFibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        System.out.println(getFibonacci(num));

    }

    public static int getFibonacci(int num) {

        if (num <= 1) {
            return num;
        }

        return getFibonacci(num - 1) + getFibonacci(num - 2);

    }
}
