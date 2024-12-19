import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).toList());

        String inputCommand = scanner.nextLine();

        while (!inputCommand.equals("end")) {

            manipulateArray(numbers, inputCommand);

            inputCommand = scanner.nextLine();
        }
    }

    public static void manipulateArray(List<Integer> numbers, String inputCommand) {
        String[] commands = inputCommand.split(" ");
        String action = commands[0];

        switch (action) {
            case "Contains" -> {
                int number = Integer.parseInt(commands[1]);
                if (numbers.contains(number)) {
                    System.out.println("Yes");
                } else {
                    System.out.println("No such number");
                }
            }
            case "Print" -> {
                String evenOrOdd = commands[1];

                if (evenOrOdd.equals("even")) {
                    printEvenNumbers(numbers);
                } else {
                    printOddNumbers(numbers);
                }
            }
            case "Get" -> {
                String action2 = commands[1];
                if (action2.equals("sum")) {
                    System.out.println(getSum(numbers));
                } else {
                    System.out.println("Invalid action!");
                }
            }
            case "Filter" -> {
                String condition = commands[1];
                int number = Integer.parseInt(commands[2]);

                printFilteredNumbers(numbers,condition,number);
            }
            default -> {
                System.out.println("Invalid action!");
            }
        }
    }

    public static void printFilteredNumbers(List<Integer> numbers, String condition, int number) {
        switch (condition) {
            case "<" ->{
                for (Integer num : numbers) {
                    if(num < number){
                        System.out.print(num + " ");
                    }
                }
            }
            case ">" ->{
                for (Integer num : numbers) {
                    if(num > number){
                        System.out.print(num + " ");
                    }
                }
            }
            case ">="->{
                for (Integer num : numbers) {
                    if(num >= number){
                        System.out.print(num + " ");
                    }
                }
            }
            case "<="->{
                for (Integer num : numbers) {
                    if(num <= number){
                        System.out.print(num + " ");
                    }
                }
            }
            default->{
                System.out.println("Invalid condition");
            }
        }
        System.out.println();
    }

    private static int getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static void printEvenNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 == 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }

    public static void printOddNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            if (number % 2 != 0) {
                System.out.print(number + " ");
            }
        }
        System.out.println();
    }
}
