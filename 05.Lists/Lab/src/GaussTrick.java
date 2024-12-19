import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList());

        for (int i = 0; i < numbers.size(); i++) {
            int sum = numbers.get(i) + numbers.getLast();
            if (i == numbers.size() - 1) {
                break;
            } else {
                numbers.set(i, sum);
                numbers.removeLast();
            }
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }

    }
}
