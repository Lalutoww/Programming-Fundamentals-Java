import java.util.Arrays;
import java.util.Scanner;

public class EncryptSortPrint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] names = new String[n];
        int[] encryptedNames = new int[n];

        for (int i = 0; i < n; i++) {
            names[i] = sc.nextLine();
            int encryptedName = 0;
            for (int j = 0; j < names[i].split("").length; j++) {
                String[] currentName = names[i].split("");
                char letter = currentName[j].charAt(0);
                switch (letter) {
                    case 'a', 'o', 'u', 'e', 'i', 'A', 'O', 'U', 'E', 'I' -> {
                        encryptedName += (int) letter * names[i].length();
                    }
                    default -> encryptedName += (int) letter / names[i].length();
                }
            }
            encryptedNames[i] = encryptedName;
        }

        Arrays.sort(encryptedNames);
        for (int i = 0; i < n; i++) {
            System.out.println(encryptedNames[i]);
        }
    }
}
