import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        String bigger;
        String smaller;

        if (input[0].length() > input[1].length()) {
            bigger = input[0];
            smaller = input[1];
        } else {
            bigger = input[1];
            smaller = input[0];
        }

        int sum = getSumOfCharacters(bigger, smaller);
        System.out.println(sum);
    }

    private static int getSumOfCharacters(String bigger, String smaller) {
        int sum = 0;
        for (int i = 0; i < bigger.length(); i++) {
            if (i < smaller.length()) {
                sum += bigger.charAt(i) * smaller.charAt(i);
            } else {
                sum += bigger.charAt(i);
            }
        }
        return sum;
    }
}
