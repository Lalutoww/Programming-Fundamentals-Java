import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Ranking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String contestData = scanner.nextLine();
        Map<String, String> contestInfo = new HashMap<>();

        storeContestInfo(contestData, contestInfo, scanner);

        String submissionData = scanner.nextLine();

        Map<String, Participant> submissionInfo = new TreeMap<>();

        storeSubmissionInfo(submissionData, contestInfo, scanner, submissionInfo);

        printOutput(submissionInfo);
    }

    private static void storeSubmissionInfo(String submissionData, Map<String, String> contestInfo, Scanner scanner, Map<String, Participant> submissionInfo) {
        while (!submissionData.equals("end of submissions")) {
            String contestNameToValidate = submissionData.split("=>")[0];
            String contestPasswordToValidate = submissionData.split("=>")[1];
            String participantName = submissionData.split("=>")[2];
            int participantScore = Integer.parseInt(submissionData.split("=>")[3]);

            String contestPassword = contestInfo.get(contestNameToValidate);
            if (contestPassword == null) {
                submissionData = scanner.nextLine();
                continue;
            }

            if (contestPassword.equals(contestPasswordToValidate)) {
                Participant participant = submissionInfo.get(participantName);
                if (participant == null) {
                    participant = new Participant(participantName);
                }

                Integer currentPoints = participant.getContests().get(contestNameToValidate);

                if (currentPoints != null) {
                    if (currentPoints >= participantScore) {
                        submissionData = scanner.nextLine();
                        continue;
                    }
                    participant.setTotalPoints(participant.getTotalPoints() - currentPoints);
                }
                participant.addContest(contestNameToValidate, participantScore);
                participant.setTotalPoints(participant.getTotalPoints() + participantScore); // Add new points
                submissionInfo.put(participantName, participant);
            }
            submissionData = scanner.nextLine();
        }
    }

    private static void storeContestInfo(String contestData, Map<String, String> contestInfo, Scanner scanner) {
        while (!contestData.equals("end of contests")) {
            String contestName = contestData.split(":")[0];
            String contestPassword = contestData.split(":")[1];

            //! There will be no case with two equal contests.
            contestInfo.put(contestName, contestPassword);

            contestData = scanner.nextLine();
        }
    }

    private static void printOutput(Map<String, Participant> submissionInfo) {
        Map.Entry<String, Participant> bestCandidate = submissionInfo.entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue().totalPoints, p1.getValue().totalPoints)).toList().getFirst();


        System.out.printf("Best candidate is %s with total %d points.%n", bestCandidate.getKey(), bestCandidate.getValue().totalPoints);

        System.out.println("Ranking: ");
        submissionInfo.forEach((k, v) -> {
            System.out.println(k);
            v.getContests().entrySet().stream().sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(entry -> System.out.printf("#  %s -> %d%n", entry.getKey(), entry.getValue()));

        });
    }

    static class Participant {
        String name;
        Map<String, Integer> contests;
        int totalPoints;

        public Participant(String name) {
            this.name = name;
            contests = new HashMap<>();
            totalPoints = 0;
        }

        public int getTotalPoints() {
            return totalPoints;
        }

        public void setTotalPoints(int totalPoints) {
            this.totalPoints = totalPoints;
        }

        public Map<String, Integer> getContests() {
            return contests;
        }

        public void addContest(String contestName, int contestPoints) {
            contests.put(contestName, contestPoints);
        }
    }
}
