import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationMapper {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        Pattern p = Pattern.compile("([=/])(?<destination>[A-Z][A-Za-z]{2,})\\1");
        Matcher destinationMatcher = p.matcher(input);

        List<String> destinations = new ArrayList<>();
        while (destinationMatcher.find()) {
            destinations.add(destinationMatcher.group("destination"));
        }
        System.out.println("Destinations: " + String.join(", ", destinations));

        System.out.println("Travel Points: " + destinations.stream().mapToInt(String::length).sum());

    }
}
