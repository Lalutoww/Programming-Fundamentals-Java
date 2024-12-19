import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManipulationBasics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList());

        String input = sc.nextLine();
        while (!input.equals("end")) {
            manipulateList(input, numbers);

            input = sc.nextLine();
        }

        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    public static void manipulateList(String input, List<Integer> numbers) {
        String[] inputSplit = input.split(" ");
        String command = inputSplit[0];

        switch (command) {
            case "Add" -> {
                int number = Integer.parseInt(inputSplit[1]);
                numbers.add(number);
            }
            case "Remove" -> {
                int number = Integer.parseInt(inputSplit[1]);
                int indexOfNumber = numbers.indexOf(number);
                if (indexOfNumber == -1) {
                    return;
                }
                numbers.remove(indexOfNumber);
            }
            case "RemoveAt" -> {
                int index = Integer.parseInt(inputSplit[1]);
                numbers.remove(index);
            }
            case "Insert" -> {
                int number = Integer.parseInt(inputSplit[1]);
                int index = Integer.parseInt(inputSplit[2]);
                numbers.add(index, number);
            }
            default -> {
                System.out.println("Invalid command!");
            }
        }
    }
}
