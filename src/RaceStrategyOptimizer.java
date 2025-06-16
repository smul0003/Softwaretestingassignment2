public class RaceStrategyOptimizer {
    public static String generateStrategy(Car car, double trackLength, int laps, String weather) {
            double totalDistance = trackLength * laps;
            double fuelEfficiency = car.getTotalFuelEfficiency();
            int tankCapacity = car.getFuelTankCapacity();
            double totalFuelRequired = totalDistance / fuelEfficiency;
            int numberOfFuelStops = (int) Math.ceil(totalFuelRequired / tankCapacity);

            double tyreWearRate = car.getTyre().getWearRate();
            int tyreDurability = (int) (100 / (tyreWearRate * 100));
            int numberOfTyreChanges = (int) Math.ceil((double) laps / tyreDurability);

            String recommendedTyreStrategy;
            if (weather.equalsIgnoreCase("rainy")) {
                recommendedTyreStrategy = "Wet Tyres Recommended";
            } else if (weather.equalsIgnoreCase("hot")) {
                recommendedTyreStrategy = "Hard Tyres Recommended";
            } else {
                recommendedTyreStrategy = "Medium Tyres Recommended";
            }

            return String.format(
                    "FuelStops=%d, TyreChanges=%d, RecommendedTyre=%s, FuelRequired=%.2fL, Efficiency=%.2fkm/L",
                    numberOfFuelStops,
                    numberOfTyreChanges,
                    recommendedTyreStrategy,
                    totalFuelRequired,
                    fuelEfficiency
            );
        }

}
