import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int area = getRectangleArea(a, b);
        System.out.println(area);
    }

    public static int getRectangleArea(int a, int b) {
        return a * b;
    }
}
