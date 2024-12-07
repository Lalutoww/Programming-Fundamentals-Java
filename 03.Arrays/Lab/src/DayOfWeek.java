import java.util.Scanner;

public class DayOfWeek {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        int day = input.nextInt();

        if (day <= 0 || day >= 8) {
            System.out.println("Invalid day!");
        } else {
            System.out.println(days[day - 1]);
        }
    }
}
