import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergingLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers1 = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());
        List<Integer> numbers2 = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());
        List<Integer> result = new ArrayList<>();

        String biggerArray;
        int smallerArraySize;
        if (numbers1.size() < numbers2.size()) {
            smallerArraySize = numbers1.size();
            biggerArray = "numbers2";
        } else {
            smallerArraySize = numbers2.size();
            biggerArray = "numbers1";
        }

        for (int i = 0; i < smallerArraySize; i++) {
            result.add(numbers1.get(i));
            result.add(numbers2.get(i));
        }

        if (biggerArray.equals("numbers1")) {
            for (int i = smallerArraySize; i < numbers1.size(); i++) {
                result.add(numbers1.get(i));
            }
        } else {
            for (int i = smallerArraySize; i < numbers2.size(); i++) {
                result.add(numbers2.get(i));
            }
        }

        for (Integer number : result) {
            System.out.print(number + " ");
        }

    }
}
