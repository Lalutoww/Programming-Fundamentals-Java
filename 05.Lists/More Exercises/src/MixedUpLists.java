import java.util.*;

public class MixedUpLists {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> firstList = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());
        List<Integer> secondList = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());

        List<Integer> result = fillResultArray(firstList, secondList);

        filterAndSortArray(result, firstList, secondList);

        for (Integer num : result) {
            System.out.print(num + " ");
        }

    }

    public static List<Integer> fillResultArray(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>();
        while (!firstList.isEmpty() && !secondList.isEmpty()) {
            result.add(firstList.getFirst());
            result.add(secondList.getLast());

            firstList.removeFirst();
            secondList.removeLast();
        }
        return result;
    }

    public static void filterAndSortArray(List<Integer> result, List<Integer> firstList, List<Integer> secondList) {
        int num1;
        int num2;
        if (!firstList.isEmpty()) {
            num1 = Math.max(firstList.getFirst(), firstList.getLast());
            num2 = Math.min(firstList.getFirst(), firstList.getLast());
        } else {
            num1 = Math.max(secondList.getFirst(), secondList.getLast());
            num2 = Math.min(secondList.getFirst(), secondList.getLast());
        }

        result.removeIf(currentNumber -> currentNumber >= num1 || currentNumber <= num2);

        Collections.sort(result);
    }
}
