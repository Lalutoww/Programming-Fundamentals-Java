import java.util.*;

public class Judge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        Map<String, Map<String, Integer>> contests = new LinkedHashMap<>();
        Map<String, Integer> userTotalPoints = new HashMap<>();

        while (!input.equals("no more time")) {
            String[] userData = input.split(" -> ");
            String userName = userData[0];
            String contestName = userData[1];
            int points = Integer.parseInt(userData[2]);

            contests.putIfAbsent(contestName, new HashMap<>());

            Map<String, Integer> participants = contests.get(contestName);
            if (!participants.containsKey(userName) || participants.get(userName) < points) {
                int previousPoints = participants.getOrDefault(userName, 0);
                participants.put(userName, points);

                userTotalPoints.put(userName, userTotalPoints.getOrDefault(userName, 0) - previousPoints + points);
            }

            input = scanner.nextLine();
        }

        for (Map.Entry<String, Map<String, Integer>> contest : contests.entrySet()) {
            System.out.printf("%s: %d participants%n", contest.getKey(), contest.getValue().size());

            List<Map.Entry<String, Integer>> sortedParticipants = new ArrayList<>(contest.getValue().entrySet());
            sortedParticipants.sort((a, b) -> {
                if (!b.getValue().equals(a.getValue())) {
                    return b.getValue() - a.getValue(); // Descending by points
                }
                return a.getKey().compareTo(b.getKey()); // Ascending by name
            });

            int position = 1;
            for (Map.Entry<String, Integer> participant : sortedParticipants) {
                System.out.printf("%d. %s <::> %d%n", position++, participant.getKey(), participant.getValue());
            }
        }

        System.out.println("Individual standings:");

        List<Map.Entry<String, Integer>> sortedUsers = new ArrayList<>(userTotalPoints.entrySet());
        sortedUsers.sort((a, b) -> {
            if (!b.getValue().equals(a.getValue())) {
                return b.getValue() - a.getValue(); // Descending by total points
            }
            return a.getKey().compareTo(b.getKey()); // Ascending by name
        });

        int position = 1;
        for (Map.Entry<String, Integer> user : sortedUsers) {
            System.out.printf("%d. %s -> %d%n", position++, user.getKey(), user.getValue());
        }
    }
}