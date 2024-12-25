import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TeamworkProjects {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<Team> teams = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] teamData = input.nextLine().split("-");
            String creatorName = teamData[0];
            String teamName = teamData[1];

            Team team = new Team(teamName, creatorName);
            if (teams.isEmpty()) {
                System.out.printf("Team %s has been created by %s!%n", teamName, creatorName);
                team.people.add(creatorName);
                teams.add(team);
            } else {
                if (!isTeamAlreadyCreated(teams, teamName)) {
                    if (isCreator(teams, creatorName)) {
                        System.out.printf("%s cannot create another team!%n", creatorName);
                        continue;
                    }
                    System.out.printf("Team %s has been created by %s!%n", teamName, creatorName);
                    team.people.add(creatorName);
                    teams.add(team);
                } else {
                    System.out.printf("Team %s was already created!%n", teamName);
                }
            }
        }

        String command = input.nextLine();
        while (!command.equals("end of assignment")) {
            String[] personData = command.split("->");
            String personName = personData[0];
            String teamName = personData[1];


            if (!isTeamAlreadyCreated(teams, teamName)) {
                System.out.printf("Team %s does not exist!%n", teamName);
            } else {
                Team currentTeam = teams.stream().filter(t -> t.name.equals(teamName)).toList().getFirst();
                if (isPersonInAnyTeam(teams, personName)) {
                    System.out.printf("Member %s cannot join team %s!%n", personName, teamName);
                    command = input.nextLine();
                    continue;
                }
                currentTeam.getPeople().add(personName);
            }
            command = input.nextLine();
        }

        List<Team> sortedTeams = teams.stream()
                .sorted((t1, t2) -> {
                    int sizeCompare = Integer.compare(t2.getPeople().size(), t1.getPeople().size());
                    if (sizeCompare == 0) {
                        return t1.getName().compareTo(t2.getName());
                    }
                    return sizeCompare;
                })
                .toList();

        for (Team team : sortedTeams) {
            team.printTeams();
        }

        System.out.println("Teams to disband:");
        findAndDisbandEmptyTeams(teams);

    }

    static void findAndDisbandEmptyTeams(List<Team> teams) {
        List<Team> sortedTeamsInAscending = teams.stream().sorted((t1, t2) -> t1.getName().compareTo(t2.getName())).toList();
        List<Team> toDisband = new ArrayList<>();
        for (Team team : sortedTeamsInAscending) {
            if (team.getPeople().size() == 1) {
                toDisband.add(team);
            }
        }
        toDisband.forEach(team -> {
            teams.remove(team);
            System.out.println(team.getName());
        });
    }

    static boolean isPersonInAnyTeam(List<Team> teams, String personName) {
        for (Team team : teams) {
            if (team.getPeople().contains(personName)) {
                return true;
            }
        }
        return false;
    }

    static boolean isCreator(List<Team> teams, String creatorName) {
        for (Team team : teams) {
            if (team.getCreatorName().equals(creatorName)) {
                return true;
            }
        }
        return false;
    }

    static boolean isTeamAlreadyCreated(List<Team> teams, String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return true;
            }
        }
        return false;
    }

    static class Team {
        String name;
        String creatorName;
        List<String> people;

        Team(String name, String creatorName) {
            this.name = name;
            this.creatorName = creatorName;
            people = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public String getCreatorName() {
            return creatorName;
        }

        public List<String> getPeople() {
            return people;
        }

        void printTeams() {
            if (people.size() > 1) {
                System.out.println(name);
                System.out.printf("- %s%n", creatorName);
                List<String> sortedMembers = people.stream().skip(1).sorted((p1, p2) -> p1.compareTo(p2)).toList();
                for (String sortedMember : sortedMembers) {
                    System.out.printf("-- %s%n", sortedMember);
                }
            }
        }
    }
}
