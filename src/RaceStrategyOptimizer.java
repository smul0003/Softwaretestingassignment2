public class RaceStrategyOptimizer {
    private double totalDistance;
    private double fuelEfficiency;
    private int tankCapacity;
    private double maxDistancePerTank;
    private int pitStops;
    private double tyreWearPerLap;
    private int tyreLifespan;
    private int tyreChanges;
    private String recommendedTyre;
    private String weather;

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

    // Getters and Setters
    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public double getFuelEfficiency() {
        return fuelEfficiency;
    }

    public void setFuelEfficiency(double fuelEfficiency) {
        this.fuelEfficiency = fuelEfficiency;
    }

    public int getTankCapacity() {
        return tankCapacity;
    }

    public void setTankCapacity(int tankCapacity) {
        this.tankCapacity = tankCapacity;
    }

    public double getMaxDistancePerTank() {
        return maxDistancePerTank;
    }

    public void setMaxDistancePerTank(double maxDistancePerTank) {
        this.maxDistancePerTank = maxDistancePerTank;
    }

    public int getPitStops() {
        return pitStops;
    }

    public void setPitStops(int pitStops) {
        this.pitStops = pitStops;
    }

    public double getTyreWearPerLap() {
        return tyreWearPerLap;
    }

    public void setTyreWearPerLap(double tyreWearPerLap) {
        this.tyreWearPerLap = tyreWearPerLap;
    }

    public int getTyreLifespan() {
        return tyreLifespan;
    }

    public void setTyreLifespan(int tyreLifespan) {
        this.tyreLifespan = tyreLifespan;
    }

    public int getTyreChanges() {
        return tyreChanges;
    }

    public void setTyreChanges(int tyreChanges) {
        this.tyreChanges = tyreChanges;
    }

    public String getRecommendedTyre() {
        return recommendedTyre;
    }

    public void setRecommendedTyre(String recommendedTyre) {
        this.recommendedTyre = recommendedTyre;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
