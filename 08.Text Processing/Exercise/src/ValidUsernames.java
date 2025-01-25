import java.util.Scanner;

public class ValidUsernames {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] usernames = sc.nextLine().split(", ");
        for (String username : usernames) {
            if (checkIfValid(username)) {
                System.out.println(username);
            }
        }
    }

    private static boolean checkIfValid(String username) {
        if (username.length() >= 3 && username.length() <= 16) {
            for (int i = 0; i < username.length(); i++) {
                if (!Character.isDigit(username.charAt(i)) && !Character.isLetter(username.charAt(i)) && username.charAt(i) != '-' && username.charAt(i) != '_') {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
