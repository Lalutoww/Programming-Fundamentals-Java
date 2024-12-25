import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarSalesman {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        List<Engine> enginesList = new ArrayList<>();
        List<Car> carsList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] engineData = input.nextLine().split(" ");
            Engine engine = getEngine(engineData);
            enginesList.add(engine);
        }

        int m = Integer.parseInt(input.nextLine());
        for (int i = 0; i < m; i++) {
            String[] carData = input.nextLine().split(" ");
            Car car = getCar(carData, enginesList);
            carsList.add(car);
        }

        for (Car car : carsList) {
            System.out.print(car);
        }
    }

    public static boolean isInteger(String input) {
        if (input == null || input.isEmpty()) {
            return false; // Null or empty strings are not integers
        }

        int startIndex = 0;
        if (input.charAt(0) == '-') {
            // If the first character is '-', check if it has digits after it
            if (input.length() == 1) {
                return false; // "-" is not a valid integer
            }
            startIndex = 1; // Skip the '-' sign
        }

        for (int i = startIndex; i < input.length(); i++) {
            char c = input.charAt(i);
            if (!Character.isDigit(c)) {
                return false; // Return false if a non-digit character is found
            }
        }

        return true; // All characters are digits or valid '-' sign
    }

    static Engine getEngine(String[] engineData) {
        String model = engineData[0];
        int power = Integer.parseInt(engineData[1]);
        Engine engine = new Engine(model, power);
        if (engineData.length == 3 && isInteger(engineData[2])) {
            int displacement = Integer.parseInt(engineData[2]);
            engine.setDisplacement(displacement);

        } else if (engineData.length == 3 && !isInteger(engineData[2])) {
            String efficiency = engineData[2];
            engine.setEfficiency(efficiency);
        } else if (engineData.length == 4) {
            int displacement = Integer.parseInt(engineData[2]);
            String efficiency = engineData[3];
            engine.setDisplacement(displacement);
            engine.setEfficiency(efficiency);
        }
        return engine;
    }

    static Car getCar(String[] carData, List<Engine> enginesList) {
        String model = carData[0];
        String engineName = carData[1];
        Engine engine = enginesList.stream().filter(e -> e.model.equals(engineName)).findFirst().orElse(null);
        Car car = new Car(model, engine);

        if (carData.length == 3 && isInteger(carData[2])) {
            int weight = Integer.parseInt(carData[2]);
            car.setWeight(weight);
        } else if (carData.length == 3 && !isInteger(carData[2])) {
            String color = carData[2];
            car.setColor(color);
        } else if (carData.length == 4) {
            int weight = Integer.parseInt(carData[2]);
            String color = carData[3];
            car.setWeight(weight);
            car.setColor(color);
        }
        return car;
    }

    static class Car {
        String model;
        Engine engine;
        int weight;
        String color;

        public Car(String model, Engine engine) {
            this.model = model;
            this.engine = engine;
            weight = 0;
            color = "n/a";

        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public void setColor(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            String actualWeight = String.valueOf(weight);
            String actualDisplacement = String.valueOf(engine.displacement);
            if (weight == 0) {
                actualWeight = "n/a";
            }
            if (engine.displacement == 0) {
                actualDisplacement = "n/a";
            }
            return String.format("""
                    %s:
                      %s:
                        Power: %s
                        Displacement: %s
                        Efficiency: %s
                      Weight: %s
                      Color: %s
                    """, model, engine.model, engine.power, actualDisplacement, engine.efficiency, actualWeight, color);
        }
    }

    static class Engine {
        String model;
        int power;
        int displacement;
        String efficiency;

        public Engine(String model, int power) {
            this.model = model;
            this.power = power;
            displacement = 0;
            efficiency = "n/a";
        }

        public void setDisplacement(int displacement) {
            this.displacement = displacement;
        }

        public void setEfficiency(String efficiency) {
            this.efficiency = efficiency;
        }
    }
}
