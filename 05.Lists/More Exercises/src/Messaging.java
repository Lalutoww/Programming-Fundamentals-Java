import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Messaging {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(input.nextLine().split(" ")).map(Integer::parseInt).toList());
        List<Character> messageCharacters = new ArrayList<>();
        String message = input.nextLine();
        for (char c : message.toCharArray()) {
            messageCharacters.add(c);
        }

        for (Integer number : numbers) {
            int sum = getSumOfDigits(number);
            while (sum >= messageCharacters.size()) {
                sum -= messageCharacters.size();
            }
            System.out.print(messageCharacters.get(sum));
            messageCharacters.remove(sum);
        }
    }
    public static int getSumOfDigits(int number)
    {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;

            number /= 10;
        }
        return sum;
    }
}


