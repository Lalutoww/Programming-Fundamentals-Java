import java.util.Arrays;
import java.util.Scanner;

public class LadyBugs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        int[] ladyBugsField = new int[length];
        int[] initialBugsIndexes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        String input;

        for (int initialBugsIndex : initialBugsIndexes) {

            if (initialBugsIndex >= 0 && initialBugsIndex < ladyBugsField.length) {
                ladyBugsField[initialBugsIndex] = 1;
            }
        }

        while (!(input = scanner.nextLine()).equals("end")) {

            String[] command = input.split(" ");
            int indexFrom = Integer.parseInt(command[0]);
            String direction = command[1];
            int indexTo = Integer.parseInt(command[2]);
            //int flyDistance = Math.abs(indexFrom - indexTo);

            if (indexFrom < 0 || indexFrom >= ladyBugsField.length || ladyBugsField[indexFrom] == 0) {
                continue;
            }

            ladyBugsField[indexFrom] = 0;
            int currentIndex = indexTo;

            if (direction.equals("right")) {
                while (indexFrom + currentIndex < ladyBugsField.length && indexFrom + currentIndex >= 0) {
                    if (ladyBugsField[indexFrom + currentIndex] == 0) {
                        ladyBugsField[indexFrom + currentIndex] = 1;
                        break;
                    } else {
                        currentIndex += indexTo;
                    }
                }
            } else if (direction.equals("left")) {
                while (indexFrom - currentIndex >= 0 && indexFrom - currentIndex < ladyBugsField.length) {
                    if (ladyBugsField[indexFrom - currentIndex] == 0) {
                        ladyBugsField[indexFrom - currentIndex] = 1;
                        break;
                    } else {
                        currentIndex += indexTo;
                    }
                }
            }
        }

        for (int nums : ladyBugsField) {
            System.out.print(nums + " ");
        }
    }
}
