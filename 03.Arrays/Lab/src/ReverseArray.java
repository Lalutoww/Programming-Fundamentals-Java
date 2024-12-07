import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] arr = sc.nextLine().split(" ");

        for (int i = 0; i < arr.length / 2; i++) {
            int lastElement = arr.length - i - 1;
            String temp = arr[lastElement];
            arr[lastElement] = arr[i];
            arr[i] = temp;
        }

        
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
