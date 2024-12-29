import java.util.Map;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class WordSynonyms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, List<String>> synonyms = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String word = sc.nextLine();
            String synonym = sc.nextLine();

            List<String> result = synonyms.get(word);

            if (result == null) {
                result = new ArrayList<>();
            }
            result.add(synonym);
            synonyms.put(word, result);
        }

        for (Map.Entry<String, List<String>> entry : synonyms.entrySet()) {
            System.out.printf("%s - %s%n", entry.getKey(), String.join(", ", entry.getValue()));
        }
    }
}