import java.text.DecimalFormat;
import java.util.Scanner;

public class MathPower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double number = input.nextDouble();
        int power = input.nextInt();

        double result = calculatePower(number, power);

        //Format the number: if numbers after floating point are 0 they are not printed
        System.out.println(new DecimalFormat("0.##").format(result));
    }

    public static double calculatePower(double number, int power) {
        double result = 1;
        for (int i = 0; i < power; i++) {
            result *= number;
        }

        return result;
    }
}
