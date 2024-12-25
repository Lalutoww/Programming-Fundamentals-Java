import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RawData {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());

        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] carData = input.nextLine().split(" ");
            Car car = getCar(carData);

            cars.add(car);
        }

        String commandCargoType = input.nextLine();
        cars = cars.stream().filter(c -> c.cargo.cargoType.equals(commandCargoType)).toList();
        switch (commandCargoType) {

            case "fragile" -> {
                List<Boolean> areTyresAllowed = isTyrePressureAllowed(cars);

                for (int i = 0; i < cars.size(); i++) {
                    if (areTyresAllowed.get(i)) {
                        System.out.println(cars.get(i).getModel());
                    }
                }
            }
            case "flamable" -> {
                List<Boolean> areEnginesAllowed = isEnginePowerAllowed(cars);

                for (int i = 0; i < cars.size(); i++) {
                    if (areEnginesAllowed.get(i)) {
                        System.out.println(cars.get(i).getModel());
                    }
                }
            }
        }
    }

    private static Car getCar(String[] carData) {
        String model = carData[0];
        int engineSpeed = Integer.parseInt(carData[1]);
        int enginePower = Integer.parseInt(carData[2]);
        int cargoWeight = Integer.parseInt(carData[3]);
        String cargoType = carData[4];
        double tyrePressure1 = Double.parseDouble(carData[5]);
        int tyreAge1 = Integer.parseInt(carData[6]);
        double tyrePressure2 = Double.parseDouble(carData[7]);
        int tyreAge2 = Integer.parseInt(carData[8]);
        double tyrePressure3 = Double.parseDouble(carData[9]);
        int tyreAge3 = Integer.parseInt(carData[10]);
        double tyrePressure4 = Double.parseDouble(carData[11]);
        int tyreAge4 = Integer.parseInt(carData[12]);

        double[] tyrePressure = {tyrePressure1, tyrePressure2, tyrePressure3, tyrePressure4};
        int[] tyreAge = {tyreAge1, tyreAge2, tyreAge3, tyreAge4};

        Engine engine = new Engine(engineSpeed, enginePower);
        Cargo cargo = new Cargo(cargoWeight, cargoType);
        Tyres tyres = new Tyres(tyrePressure, tyreAge);

        return new Car(model, engine, cargo, tyres);
    }

    private static List<Boolean> isTyrePressureAllowed(List<Car> cars) {
        List<Boolean> isTyrePressureAllowed = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
            isTyrePressureAllowed.add(i, false);
            for (int j = 0; j < 4; j++) {
                if (cars.get(i).tyres.tyrePressure[j] < 1) {
                    isTyrePressureAllowed.set(i, true);
                    break;
                }
            }
        }
        return isTyrePressureAllowed;
    }

    private static List<Boolean> isEnginePowerAllowed(List<Car> cars) {
        List<Boolean> isEnginePowerAllowed = new ArrayList<>();
        for (Car car : cars) {
            if (car.engine.enginePower > 250) {
                isEnginePowerAllowed.add(true);
            } else {
                isEnginePowerAllowed.add(false);
            }
        }
        return isEnginePowerAllowed;
    }

    static class Car {
        String model;
        Engine engine;
        Cargo cargo;
        Tyres tyres;

        public Car(String model, Engine engine, Cargo cargo, Tyres tyres) {
            this.model = model;
            this.engine = engine;
            this.cargo = cargo;
            this.tyres = tyres;
        }

        public String getModel() {
            return model;
        }
    }

    static class Engine {
        int engineSpeed;
        int enginePower;

        public Engine(int engineSpeed, int enginePower) {
            this.engineSpeed = engineSpeed;
            this.enginePower = enginePower;
        }
    }

    static class Cargo {
        int cargoWeight;
        String cargoType;

        public Cargo(int cargoWeight, String cargoType) {
            this.cargoWeight = cargoWeight;
            this.cargoType = cargoType;
        }
    }

    static class Tyres {
        double[] tyrePressure;
        int[] tyreAge;

        public Tyres(double[] tyrePressure, int[] tyreAge) {
            this.tyrePressure = tyrePressure;
            this.tyreAge = tyreAge;
        }
    }
}