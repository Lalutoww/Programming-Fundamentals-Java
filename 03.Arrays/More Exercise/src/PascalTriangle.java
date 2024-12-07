import java.util.Scanner;

public class PascalTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = Integer.parseInt(scanner.nextLine());
        int[][] pascalTriangle = new int[num][num];


        for (int i = 0; i < num; i++) {

            for (int j = 0; j <= i; j++) {

                if (i == j || j == 0) {

                    pascalTriangle[i][j] = 1;

                } else {

                    pascalTriangle[i][j] = pascalTriangle[i - 1][j - 1] + pascalTriangle[i - 1][j];

                }

                System.out.print(pascalTriangle[i][j] + " ");

            }

            System.out.println();

        }
    }
}
