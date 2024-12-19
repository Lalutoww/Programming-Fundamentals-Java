import java.util.*;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> words = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).toList());
        Random rand = new Random();
        int initialSize = words.size();

        for (int i = 0; i < initialSize; i++) {
            int num = rand.nextInt(words.size());
            System.out.println(words.get(num));
            words.remove(num);
        }
    }
}
