public class RaceStrategyOptimizer {
    public static void generateStrategy(Car car, double trackLengthKm, int laps, String weather) {
        double totalDistance = trackLengthKm * laps;
        double fuelEfficiency = car.getTotalFuelEfficiency();
        int tankCapacity = car.getFuelTankCapacity();

        double maxDistancePerTank = tankCapacity * fuelEfficiency;
        int pitStops = (int)Math.ceil(totalDistance / maxDistancePerTank) - 1;

        // Estimate tyre wear
        double tyreWearPerLap = car.tyre.getWearRate();
        int tyreLifespan = (int)(1.0 / tyreWearPerLap);

        // Adjust for weather
        if (weather.equalsIgnoreCase("wet")) {
            tyreLifespan = (int)(tyreLifespan * 0.7);
        }

        int tyreChanges = (int)Math.ceil((double)laps / tyreLifespan) - 1;

        System.out.println("\n--- Race Strategy ---");
        System.out.printf("Track: %.1fkm x %d laps (Total: %.1fkm)%n", trackLengthKm, laps, totalDistance);
        System.out.printf("Estimated Fuel Stops: %d%n", Math.max(0, pitStops));
        System.out.printf("Estimated Tyre Changes: %d (Tyre lifespan: ~%d laps)%n", Math.max(0, tyreChanges), tyreLifespan);
        System.out.println("Recommended Tyre: " + car.tyre.getCompound());
        System.out.println("Weather: " + weather);
    }
}
