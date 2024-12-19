import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arrayOfNumbers = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        String command = scanner.nextLine();

        while (!command.equals("end")) {
            int[] newArray = manipulateArray(command, arrayOfNumbers);

            if (newArray != null) {
                System.arraycopy(newArray, 0, arrayOfNumbers, 0, newArray.length);
            }

            command = scanner.nextLine();
        }

        printArray(arrayOfNumbers);
    }

    public static int[] manipulateArray(String command, int[] arrayOfNumbers) {
        String[] commands = command.split(" ");

        switch (commands[0]) {
            case "exchange" -> {
                if (Integer.parseInt(commands[1]) >= arrayOfNumbers.length || Integer.parseInt(commands[1]) < 0) {
                    System.out.println("Invalid index");
                    return null;
                }
                return exchangeNumbers(arrayOfNumbers, commands);
            }
            case "max" -> {
                String evenOrOdd = commands[1];
                if (getMaxNumber(evenOrOdd, arrayOfNumbers) == -1) {
                    System.out.println("No matches");
                    return null;
                }
                System.out.println(getMaxNumber(evenOrOdd, arrayOfNumbers));
                return null;
            }
            case "min" -> {
                String evenOrOdd = commands[1];
                if (getMaxNumber(evenOrOdd, arrayOfNumbers) == -1) {
                    System.out.println("No matches");
                    return null;
                }
                System.out.println(getMinNumber(evenOrOdd, arrayOfNumbers));
                return null;
            }
            case "first" -> {
                int count = Integer.parseInt(commands[1]);
                if (count > arrayOfNumbers.length) {
                    System.out.println("Invalid count");
                    return null;
                }
                String evenOrOdd = commands[2];

                printArray(getFirstElements(count, evenOrOdd, arrayOfNumbers));
                return null;
            }
            case "last" -> {
                int count = Integer.parseInt(commands[1]);
                if (count > arrayOfNumbers.length) {
                    System.out.println("Invalid count");
                    return null;
                }
                String evenOrOdd = commands[2];
                printReversedArray(getLastElements(count, evenOrOdd, arrayOfNumbers));
                return null;

            }
            default -> {
                System.out.println("Invalid command!");
                return null;
            }
        }
    }

    private static int[] exchangeNumbers(int[] arrayOfNumbers, String[] commands) {
        int[] finalArray = new int[arrayOfNumbers.length];
        int count = 0;

        for (int i = Integer.parseInt(commands[1]) + 1; i < arrayOfNumbers.length; i++) {
            finalArray[count] = arrayOfNumbers[i];
            count++;
        }

        for (int i = 0; i <= Integer.parseInt(commands[1]); i++) {
            finalArray[count] = arrayOfNumbers[i];
            count++;
        }
        return finalArray;
    }

    public static int getMaxNumber(String command, int[] arrayOfNumbers) {
        int maxNumber = Integer.MIN_VALUE;
        int maxIndex = -1;

        switch (command) {
            case "even" -> {
                for (int i = 0; i < arrayOfNumbers.length; i++) {
                    if (arrayOfNumbers[i] % 2 == 0 && arrayOfNumbers[i] >= maxNumber) {
                        maxIndex = i;
                        maxNumber = arrayOfNumbers[i];
                    }
                }
                return maxIndex;
            }
            case "odd" -> {
                for (int i = 0; i < arrayOfNumbers.length; i++) {
                    if (arrayOfNumbers[i] % 2 != 0 && arrayOfNumbers[i] >= maxNumber) {
                        maxIndex = i;
                        maxNumber = arrayOfNumbers[i];
                    }
                }
                return maxIndex;
            }
            default -> {
                return -1;
            }
        }
    }

    public static int getMinNumber(String command, int[] arrayOfNumbers) {
        int minNumber = Integer.MAX_VALUE;
        int minIndex = -1;

        switch (command) {
            case "even" -> {
                for (int i = 0; i < arrayOfNumbers.length; i++) {
                    if (arrayOfNumbers[i] % 2 == 0 && arrayOfNumbers[i] <= minNumber) {
                        minIndex = i;
                        minNumber = arrayOfNumbers[i];
                    }
                }
                return minIndex;
            }
            case "odd" -> {
                for (int i = 0; i < arrayOfNumbers.length; i++) {
                    if (arrayOfNumbers[i] % 2 != 0 && arrayOfNumbers[i] <= minNumber) {
                        minIndex = i;
                        minNumber = arrayOfNumbers[i];
                    }
                }
                return minIndex;
            }
            default -> {
                return -1;
            }
        }
    }

    public static int[] getFirstElements(int count, String evenOrOdd, int[] arrayOfNumbers) {
        if (arrayOfNumbers.length == 0) {
            return new int[0];
        }
        int matchingElements = countMatchingElements(evenOrOdd, arrayOfNumbers);
        int arraySize = Math.min(matchingElements, count);
        int[] firstElements = new int[arraySize];
        int counter = 0;

        switch (evenOrOdd) {
            case "even" -> {
                for (int number : arrayOfNumbers) {
                    if (number % 2 == 0) {
                        firstElements[counter] = number;
                        counter++;
                        if (counter == count) {
                            break;
                        }

                    }
                }
                return firstElements;
            }
            case "odd" -> {
                for (int number : arrayOfNumbers) {
                    if (number % 2 != 0) {
                        firstElements[counter] = number;
                        counter++;
                        if (counter == count) {
                            break;
                        }

                    }
                }
                return firstElements;
            }
            default -> {
                return new int[0];
            }
        }
    }

    public static int[] getLastElements(int count, String evenOrOdd, int[] arrayOfNumbers) {
        if (arrayOfNumbers.length == 0) {
            return new int[0];
        }
        int matchingElements = countMatchingElements(evenOrOdd, arrayOfNumbers);
        int arraySize = Math.min(matchingElements, count);
        int[] lastElements = new int[arraySize];
        int counter = 0;

        switch (evenOrOdd) {
            case "even" -> {
                for (int i = arrayOfNumbers.length - 1; i >= 0; i--) {
                    if (arrayOfNumbers[i] % 2 == 0) {
                        lastElements[counter] = arrayOfNumbers[i];
                        counter++;
                        if (counter == count) {
                            break;
                        }

                    }
                }
                return lastElements;
            }
            case "odd" -> {
                for (int i = arrayOfNumbers.length - 1; i >= 0; i--) {
                    if (arrayOfNumbers[i] % 2 != 0) {
                        lastElements[counter] = arrayOfNumbers[i];
                        counter++;
                        if (counter == count) {
                            break;
                        }

                    }
                }
                return lastElements;
            }
            default -> {
                return new int[0];
            }
        }
    }

    public static int countMatchingElements(String evenOrOdd, int[] arrayOfNumbers) {
        int matchingCount = 0;
        switch (evenOrOdd) {
            case "even" -> {
                for (int num : arrayOfNumbers) {
                    if (num % 2 == 0) matchingCount++;
                }
                return matchingCount;
            }
            case "odd" -> {
                for (int num : arrayOfNumbers) {
                    if (num % 2 != 0) matchingCount++;
                }
                return matchingCount;
            }
            default -> {
                return 0;
            }
        }
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print("[");
            }
            System.out.print(array[i]);
            if (i == array.length - 1) {
                System.out.print("]");
            }
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        if (array.length == 0) {
            System.out.print("[]");
        }
        System.out.println();
    }

    public static void printReversedArray(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (i == array.length - 1) {
                System.out.print("[");
            }
            System.out.print(array[i]);
            if (i == 0) {
                System.out.print("]");
            }
            if (i > 0) {
                System.out.print(", ");
            }
        }
        if (array.length == 0) {
            System.out.print("[]");
        }
        System.out.println();
    }
}
