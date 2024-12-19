import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TakeSkipRope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message = scanner.nextLine();

        List<Integer> numbers = new ArrayList<>();
        List<Character> nonNumbers = new ArrayList<>();

        List<Integer> takeList = new ArrayList<>();
        List<Integer> skipList = new ArrayList<>();

        fillNumbersAndNonNumbers(message, numbers, nonNumbers);

        fillTakeAndSkip(numbers, takeList, skipList);

        List<Character> result = (getResult(nonNumbers, takeList, skipList));
        for (Character character : result) {
            System.out.print(character);
        }


    }

    private static List<Character> getResult(List<Character> nonNumbers, List<Integer> takeList, List<Integer> skipList) {
        List<Character> result = new ArrayList<>();

        while (!takeList.isEmpty() || !skipList.isEmpty()) {
            if (takeList.getFirst() > nonNumbers.size()) {
                result.addAll(nonNumbers);
                nonNumbers.clear();
            } else {
                for (int i = 0; i < takeList.getFirst(); i++) {
                    result.add(nonNumbers.get(i));
                }
                for (int i = 0; i < takeList.getFirst(); i++) {
                    nonNumbers.removeFirst();
                }
            }

            if (skipList.getFirst() > nonNumbers.size()) {
                nonNumbers.clear();
            } else {
                for (int j = 0; j < skipList.getFirst(); j++) {
                    nonNumbers.removeFirst();
                }
            }

            takeList.removeFirst();
            skipList.removeFirst();
        }
        return result;
    }

    private static void fillTakeAndSkip(List<Integer> numbers, List<Integer> takeList, List<Integer> skipList) {
        for (int i = 0; i < numbers.size(); i++) {
            if (i % 2 == 0) {
                takeList.add(numbers.get(i));
            } else {
                skipList.add(numbers.get(i));
            }
        }
    }

    private static void fillNumbersAndNonNumbers(String message, List<Integer> numbers, List<Character> nonNumbers) {
        for (int i = 0; i < message.length(); i++) {
            if (message.charAt(i) >= '0' && message.charAt(i) <= '9') {
                int number = message.charAt(i) - '0';
                numbers.add(number);
            } else {
                nonNumbers.add(message.charAt(i));
            }
        }
    }
}
