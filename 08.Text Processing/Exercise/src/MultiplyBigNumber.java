import java.util.Scanner;

public class MultiplyBigNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String bigNum = scanner.nextLine();

        int num = Integer.parseInt(scanner.nextLine());

        if (num == 0) {
            System.out.println(0);
            return;
        }

        int remainder = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = bigNum.length() - 1; i >= 0; i--) {

            int currentRes = 0;

            int product = Integer.parseInt(String.valueOf(bigNum.charAt(i))) * num;
            if (i == 0) {
                int remaining = product + remainder;
                String preReversed = Integer.toString(remaining);

                String reversedNum = new StringBuffer(preReversed).reverse().toString();
                sb.append(reversedNum);
                break;
            }

            if (product + remainder < 10) {

                currentRes = product + remainder;
                sb.append(currentRes);
                remainder = 0;

            } else {
                currentRes = product + remainder;
                sb.append(currentRes % 10);
                currentRes /= 10;
                remainder = currentRes;
            }

        }

        while (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb.reverse());
    }
}
