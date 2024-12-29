import java.util.*;

public class MOBAChallenger {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Player> players = new ArrayList<>();

        while (!input.equals("Season end")) {
            if (input.contains("->")) {
                String[] playerData = input.split(" -> ");
                String playerName = playerData[0];
                String position = playerData[1];
                int skill = Integer.parseInt(playerData[2]);

                Player player = players.stream().filter(u -> u.getName().equals(playerName)).findFirst().orElse(null);

                if (player == null) {
                    player = new Player(playerName);
                    player.setPositions(position, skill);
                    player.setTotalSkill(skill);
                    players.add(player);

                }

                if (!player.getPositions().containsKey(position)) {
                    player.setPositions(position, skill);
                    player.setTotalSkill(skill);
                } else if (player.getPositions().get(position) < skill) {
                    player.setTotalSkill(-player.getPositions().get(position));
                    player.setTotalSkill(skill);
                    player.setPositions(position, skill);
                }


            } else {
                String[] playersDuel = input.split(" vs ");
                String playerOneName = playersDuel[0];
                String playerTwoName = playersDuel[1];

                Player playerOne = players.stream().filter(p -> p.getName().equals(playerOneName)).findFirst().orElse(null);
                Player playerTwo = players.stream().filter(p -> p.getName().equals(playerTwoName)).findFirst().orElse(null);

                if (playerOne != null && playerTwo != null) {
                    for (Map.Entry<String, Integer> entry : playerOne.getPositions().entrySet()) {
                        if (playerTwo.getPositions().containsKey(entry.getKey())) {
                            if (playerOne.getTotalSkill() > playerTwo.getTotalSkill()) {
                                players.remove(playerTwo);
                                break;
                            } else if (playerTwo.getTotalSkill() > playerOne.getTotalSkill()) {
                                players.remove(playerOne);
                                break;
                            }
                        }
                    }
                }
            }

            input = sc.nextLine();
        }
        players.stream().sorted((p1, p2) -> {
                    if (p1.getTotalSkill() != p2.getTotalSkill()) {
                        return Integer.compare(p2.getTotalSkill(), p1.getTotalSkill());
                    }
                    return p1.getName().compareTo(p2.getName());
                })
                .forEach(p -> {
                    System.out.printf("%s: %d skill%n", p.getName(), p.getTotalSkill());
                    p.getPositions().entrySet().stream().sorted((p1, p2) -> {
                        if (p1.getValue() != p2.getValue()) {
                            return Integer.compare(p2.getValue(), p1.getValue());
                        }
                        return p1.getKey().compareTo(p2.getKey());
                    }).forEach(entry -> {
                        System.out.printf("- %s <::> %d%n", entry.getKey(), entry.getValue());
                    });
                });
    }

    static class Player {
        String name;
        Map<String, Integer> positions;
        int totalSkill;

        Player(String name) {
            this.name = name;
            positions = new HashMap<>();
            totalSkill = 0;
        }

        public String getName() {
            return name;
        }


        public Map<String, Integer> getPositions() {
            return positions;
        }

        public void setPositions(String position, Integer skill) {
            this.positions.put(position, skill);
        }

        public int getTotalSkill() {
            return totalSkill;
        }

        public void setTotalSkill(int totalSkill) {
            this.totalSkill += totalSkill;
        }
    }
}
