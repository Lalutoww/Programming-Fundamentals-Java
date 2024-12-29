import java.util.List;
import java.util.Scanner;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class Snowwhite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        List<Dwarf> dwarves = new ArrayList<>();
        Map<String, Integer> dwarvesCount = new HashMap<>();

        registerDwarves(input, dwarves, dwarvesCount, sc);

        printDwarves(dwarves, dwarvesCount);
    }

    private static void registerDwarves(String input, List<Dwarf> dwarves, Map<String, Integer> dwarvesCount, Scanner sc) {
        while (!input.equals("Once upon a time")) {
            String[] dwarfData = input.split(" <:> ");
            String name = dwarfData[0];
            String hatColor = dwarfData[1];
            int physics = Integer.parseInt(dwarfData[2]);

            Dwarf dwarf = dwarves.stream().filter(d -> d.getName().equals(name) && d.getHatColor().equals(hatColor)).findFirst().orElse(null);

            if (dwarf == null) {
                dwarf = new Dwarf(name, hatColor, physics);
                dwarves.add(dwarf);
                dwarvesCount.put(dwarf.getHatColor(), dwarvesCount.getOrDefault(dwarf.getHatColor(), 0) + 1);
            } else {
                if (dwarf.getPhysics() < physics) {
                    dwarf.setPhysics(physics);
                }
            }
            input = sc.nextLine();
        }
    }

    private static void printDwarves(List<Dwarf> dwarves, Map<String, Integer> dwarvesCount) {
        dwarves.stream().sorted((d1, d2) -> {
                    if (d1.getPhysics() != d2.getPhysics()) {
                        return Integer.compare(d2.getPhysics(), d1.getPhysics());
                    }
                    int hatColorCount1 = dwarvesCount.getOrDefault(d2.getHatColor(), 0);
                    int hatColorCount2 = dwarvesCount.getOrDefault(d1.getHatColor(), 0);
                    return Integer.compare(hatColorCount1, hatColorCount2);
                })
                .forEach(dwarf -> System.out.printf("(%s) %s <-> %d%n", dwarf.getHatColor(), dwarf.getName(), dwarf.getPhysics()));
    }

    static class Dwarf {
        String name;
        String hatColor;
        int physics;

        public Dwarf(String name, String hatColor, int physics) {
            this.name = name;
            this.hatColor = hatColor;
            this.physics = physics;
        }

        public String getName() {
            return name;
        }

        public String getHatColor() {
            return hatColor;
        }

        public int getPhysics() {
            return physics;
        }

        public void setPhysics(int physics) {
            this.physics = physics;
        }
    }
}
