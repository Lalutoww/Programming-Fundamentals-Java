import java.util.Scanner;

public class EnglishNameOfTheLastDigit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int number = sc.nextInt();
        int lastDigit = number % 10;

        switch (lastDigit) {
            case 1 -> System.out.println("one");
            case 2 -> System.out.println("two");
            case 3 -> System.out.println("three");
            case 4 -> System.out.println("four");
            case 5 -> System.out.println("five");
            case 6 -> System.out.println("six");
            case 7 -> System.out.println("seven");
            case 8 -> System.out.println("eight");
            case 9 -> System.out.println("nine");
            case 0 -> System.out.println("zero");
        }

    }
}
