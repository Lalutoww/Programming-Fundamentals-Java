import java.util.Arrays;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int length = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();
        int bestSequenceSum = 0;
        int bestSequenceIndex = 0;
        int count = 0;
        int sequenceIndex = length;
        int[] bestDNASequence = new int[length];

        while (!line.equals("Clone them!")) {

            int[] dnaSequence = Arrays.stream(line.split("!+")).mapToInt(Integer::parseInt).toArray();
            int sum = 0;
            int index = length;
            count++;

            for (int i = 0; i < dnaSequence.length; i++) {
                if ((i != dnaSequence.length - 1) && dnaSequence[i] == 1 && dnaSequence[i + 1] == 1
                        && index == length) {
                    index = i;
                }

                sum += dnaSequence[i];

            }

            if (index == sequenceIndex && sum > bestSequenceSum) {

                bestDNASequence = dnaSequence;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;

            } else if (index < sequenceIndex) {

                bestDNASequence = dnaSequence;
                bestSequenceIndex = count;
                bestSequenceSum = sum;
                sequenceIndex = index;

            }

            line = scanner.nextLine();

        }

        if (bestSequenceSum == 0) {
            bestSequenceIndex = 1;
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestSequenceIndex, bestSequenceSum);
        for (int nums : bestDNASequence) {
            System.out.print(nums + " ");
        }
    }
}
