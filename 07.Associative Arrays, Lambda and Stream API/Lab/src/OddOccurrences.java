import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineOfWords = scanner.nextLine().split(" ");
        Map<String, Integer> wordOccurrences = new LinkedHashMap<>();

        for (String word : lineOfWords) {
            Integer result = wordOccurrences.get(word.toLowerCase());

            if (result == null) {
                wordOccurrences.put(word.toLowerCase(), 1);
            } else {
                wordOccurrences.put(word.toLowerCase(), result + 1);
            }
        }

        List<String> oddOccurrences = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : wordOccurrences.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddOccurrences.add(entry.getKey());
            }
        }

        System.out.println(String.join(", ", oddOccurrences));

    }
}
