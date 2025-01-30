import java.util.*;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        Map<String, Plant> plants = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String[] plantData = sc.nextLine().split("<->");
            String plantName = plantData[0];
            int plantRarity = Integer.parseInt(plantData[1]);
            Plant currentPlant = new Plant(plantName, plantRarity);
            plants.put(plantName, currentPlant);
        }

        String command = sc.nextLine();
        while (!command.equals("Exhibition")) {
            String[] commandParams = command.split(": ");
            String commandName = commandParams[0];
            switch (commandName) {
                case "Rate" -> {
                    String plantName = commandParams[1].split(" - ")[0];
                    double rating = Double.parseDouble(commandParams[1].split(" - ")[1]);

                    ratePlant(plants, plantName, rating);
                }
                case "Update" -> {
                    String plantName = commandParams[1].split(" - ")[0];
                    int rarity = Integer.parseInt(commandParams[1].split(" - ")[1]);

                    updatePlant(plants, plantName, rarity);
                }
                case "Reset" -> {
                    String plantName = commandParams[1].split(" - ")[0];

                    resetPlant(plants, plantName);
                }
            }
            command = sc.nextLine();
        }
        System.out.println("Plants for the exhibition:");
        plants.forEach((k, v) -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", k, v.getRarity(), v.getAverageRating()));

    }

    private static void resetPlant(Map<String, Plant> plants, String plantName) {
        if (plants.containsKey(plantName)) {
            Plant plant = plants.get(plantName);
            plant.setRatings(new ArrayList<>());
        } else {
            System.out.println("error");
        }
    }

    private static void updatePlant(Map<String, Plant> plants, String plantName, int rarity) {
        if (plants.containsKey(plantName)) {
            Plant plant = plants.get(plantName);
            plant.setRarity(rarity);
        } else {
            System.out.println("error");
        }
    }

    private static void ratePlant(Map<String, Plant> plants, String plantName, double rating) {
        if (plants.containsKey(plantName)) {
            Plant plant = plants.get(plantName);
            plant.addRating(rating);
        } else {
            System.out.println("error");
        }
    }

    public static class Plant {
        private String name;
        private int rarity;
        private List<Double> ratings;

        public Plant(String name, int rarity) {
            this.name = name;
            this.rarity = rarity;
            this.ratings = new ArrayList<>();
        }

        public int getRarity() {
            return rarity;
        }

        public void setRarity(int rarity) {
            this.rarity = rarity;
        }

        public void setRatings(List<Double> ratings) {
            this.ratings = ratings;
        }

        public void addRating(double rating) {
            this.ratings.add(rating);
        }

        public double getAverageRating() {
            return this.ratings.stream().mapToDouble(d -> d).average().orElse(0.00);
        }
    }
}
