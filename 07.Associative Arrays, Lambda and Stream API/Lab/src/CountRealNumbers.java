import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        Map<Integer, Integer> numberCounts = new TreeMap<>();

        for (int i = 0; i < input.length; i++) {
            int number = Integer.parseInt(input[i]);

            Integer result = numberCounts.get(number);

            if (result == null) {
                numberCounts.put(number, 1);
            } else {
                numberCounts.put(number, result + 1);
            }

        }

        for (Map.Entry<Integer, Integer> entry : numberCounts.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

}
