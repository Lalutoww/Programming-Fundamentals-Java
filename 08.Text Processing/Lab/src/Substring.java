import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String wordToRemove = sc.nextLine();
        String originalString = sc.nextLine();

        while (originalString.contains(wordToRemove)) {
            originalString = originalString.replace(wordToRemove, "");
        }

        System.out.println(originalString);
    }
}
