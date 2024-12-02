import java.math.BigDecimal;
import java.util.Scanner;

public class ExactSumOfRealNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numbers = sc.nextInt();

        BigDecimal sum = new BigDecimal(0);
        for (int i = 0; i < numbers; i++) {
            BigDecimal number = new BigDecimal(sc.next());
            sum = sum.add(number);
        }

        System.out.println(sum);
    }
}
