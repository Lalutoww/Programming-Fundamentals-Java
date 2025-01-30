import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder stops = new StringBuilder(sc.nextLine());
        String command = sc.nextLine();

        while (!command.equals("Travel")) {
            String[] currentCommand = command.split(":");
            String commandName = currentCommand[0];

            switch (commandName) {
                case "Add Stop" -> {
                    int index = Integer.parseInt(currentCommand[1]);
                    String destination = currentCommand[2];
                    addStop(stops, index, destination);
                }
                case "Remove Stop" -> {
                    int startIndex = Integer.parseInt(currentCommand[1]);
                    int endIndex = Integer.parseInt(currentCommand[2]);
                    removeStop(startIndex, endIndex, stops);
                }
                case "Switch" -> {
                    String oldDestination = currentCommand[1];
                    String newDestination = currentCommand[2];
                    stops = switchDestinations(stops, oldDestination, newDestination);
                }
            }
            command = sc.nextLine();
        }
        System.out.println("Ready for world tour! Planned stops: " + stops);
    }

    private static StringBuilder switchDestinations(StringBuilder stops, String oldDestination, String newDestination) {
        String stopsString = stops.toString();
        if (stopsString.contains(oldDestination)) {
            stops = new StringBuilder(stopsString.replaceAll(oldDestination, newDestination));
        }
        System.out.println(stops);
        return stops;
    }

    private static void removeStop(int startIndex, int endIndex, StringBuilder stops) {
        if (startIndex >= 0 && endIndex < stops.length() && startIndex <= endIndex) {
            stops.delete(startIndex, endIndex + 1);
        }
        System.out.println(stops);
    }

    private static void addStop(StringBuilder stops, int index, String destination) {
        if (index >= 0 && index < stops.length()) {
            stops.insert(index, destination);
        }
        System.out.println(stops);
    }
}