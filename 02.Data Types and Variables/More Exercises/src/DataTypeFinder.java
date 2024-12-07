import java.util.Scanner;

public class DataTypeFinder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String command = sc.nextLine();
        while (!command.equals("END")) {
            Scanner input = new Scanner(command);
            String variableType = "";

            if (input.hasNextBoolean()) {
                variableType = "boolean";
            } else if (input.hasNextInt()) {
                variableType = "integer";
            } else if (input.hasNextDouble()) {
                variableType = "floating point";
            } else if (command.length() == 1) {
                variableType = "character";
            } else if (input.hasNextLine()) {
                variableType = "string";
            }

            System.out.printf("%s is %s type%n", command, variableType);
            command = sc.nextLine();
        }
    }
}
