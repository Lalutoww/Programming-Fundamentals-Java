import java.util.Scanner;

public class BalancedBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isBalanced = true;
        boolean isOpen = false;
        int openingBracketCount = 0;
        int closingBracketCount = 0;
        int consecutiveOpeningBracketsCount = 0;

        int num = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < num; i++) {

            String input = scanner.nextLine();

            if (isOpen && input.equals("(")) {
                System.out.println("UNBALANCED");
                isBalanced = false;
                break;
            } else {
                isOpen = false;
            }

            if (input.equals("(")) {
                openingBracketCount++;
                isOpen = true;
            } else if (input.equals(")")) {
                closingBracketCount++;
            }

            if (input.equals("(") && i == num - 1) {
                System.out.println("UNBALANCED");
                isBalanced = false;
                break;
            }
        }
        if (isBalanced) {
            if (openingBracketCount == closingBracketCount) {
                System.out.println("BALANCED");
            } else {
                System.out.println("UNBALANCED");
            }
        }
    }
}
