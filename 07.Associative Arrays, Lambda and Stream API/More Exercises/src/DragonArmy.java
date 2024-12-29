import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberOfDragons = Integer.parseInt(sc.nextLine());

        Map<String, Map<String, Dragon>> dragonsByType = new LinkedHashMap<>();

        registerDragons(numberOfDragons, sc, dragonsByType);

        printDragons(dragonsByType);
    }

    private static void printDragons(Map<String, Map<String, Dragon>> dragonsByType) {
        dragonsByType.forEach((type, dragons) -> {
            double averageDamage = dragons.values().stream().mapToDouble(Dragon::getDamage).average().orElse(0.0);
            double averageHealth = dragons.values().stream().mapToDouble(Dragon::getHealth).average().orElse(0.0);
            double averageArmor = dragons.values().stream().mapToDouble(Dragon::getArmor).average().orElse(0.0);

            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, averageDamage, averageHealth, averageArmor);

            dragons.values().stream()
                    .sorted((d1, d2) -> d1.getName().compareToIgnoreCase(d2.getName()))
                    .forEach(dragon -> System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f%n",
                            dragon.getName(), dragon.getDamage(), dragon.getHealth(), dragon.getArmor()));
        });
    }

    private static void registerDragons(int numberOfDragons, Scanner sc, Map<String, Map<String, Dragon>> dragonsByType) {
        for (int i = 0; i < numberOfDragons; i++) {
            String[] dragonData = sc.nextLine().split(" ");
            String type = dragonData[0];
            String name = dragonData[1];
            double damage = dragonData[2].equals("null") ? 45.00 : Double.parseDouble(dragonData[2]);
            double health = dragonData[3].equals("null") ? 250.00 : Double.parseDouble(dragonData[3]);
            double armor = dragonData[4].equals("null") ? 10.00 : Double.parseDouble(dragonData[4]);

            dragonsByType.putIfAbsent(type, new LinkedHashMap<>());
            dragonsByType.get(type).put(name, new Dragon(type, name, damage, health, armor));
        }
    }

    static class Dragon {
        String type;
        String name;
        double damage;
        double health;
        double armor;

        public Dragon(String type, String name, double damage, double health, double armor) {
            this.type = type;
            this.name = name;
            this.damage = damage;
            this.health = health;
            this.armor = armor;
        }

        public String getName() {
            return name;
        }

        public double getDamage() {
            return damage;
        }

        public double getHealth() {
            return health;
        }

        public double getArmor() {
            return armor;
        }
    }
}