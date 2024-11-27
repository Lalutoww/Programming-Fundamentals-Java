import java.util.Scanner;

public class TimeAfterThirtyMinutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hours = Integer.parseInt(sc.nextLine());
        int minutes = Integer.parseInt(sc.nextLine());

        int totalMinutes = hours * 60 + minutes + 30;
        int newHours = totalMinutes / 60;
        int newMinutes = totalMinutes % 60;

        if (newHours == 24) newHours = 0;

        System.out.printf("%d:%02d", newHours, newMinutes);
    }
}
