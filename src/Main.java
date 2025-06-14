public class Main {
    public static void main(String[] args) {
        Engine engine = EngineFactory.create("Turbocharged");
        Tyre tyre = TyreFactory.create("Medium");
        AeroKit aeroKit = AeroKitFactory.create("Hybrid Kit");

        int fuelTankCapacity = 100;
        double baseHandling = 7.0;

        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);

        double trackLength = 5.0;  // km
        int laps = 60;
        String weather = "sunny";

        String strategy = RaceStrategyOptimizer.generateStrategy(car, trackLength, laps, weather);
        System.out.println("Optimized Strategy: " + strategy);
    }
}
