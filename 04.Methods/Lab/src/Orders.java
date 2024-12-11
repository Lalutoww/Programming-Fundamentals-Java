import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String product = input.nextLine();
        int quantity = input.nextInt();

        double totalPrice = calculatePrice(product, quantity);

        System.out.printf("%.2f", totalPrice);

    }

    public static double calculatePrice(String product, int quantity) {
        switch (product) {
            case "coffee" -> {
                return 1.50 * quantity;
            }
            case "water" -> {
                return 1.00 * quantity;
            }
            case "coke" -> {
                return 1.40 * quantity;
            }
            case "snacks" -> {
                return 2.00 * quantity;
            }
            default -> {
                System.out.println("Invalid product!");
                return 0;
            }
        }
    }

}
