import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchDates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pattern pattern = Pattern.compile("(?<day>\\d{2})(?<separator>[/.-])(?<month>[A-Z][a-z]{2})\\k<separator>(?<year>\\d{4})");
        String text = sc.nextLine();
        Matcher dateMatcher = pattern.matcher(text);

        while (dateMatcher.find()) {
            System.out.printf("Day: %s, Month: %s, Year: %s%n", dateMatcher.group("day"), dateMatcher.group("month"), dateMatcher.group("year"));
        }
    }
}
