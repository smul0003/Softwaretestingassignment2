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

    public void generateStrategy(Car car, double trackLengthKm, int laps, String weather) {
        this.weather = weather;
        this.totalDistance = trackLengthKm * laps;
        this.fuelEfficiency = car.getTotalFuelEfficiency();
        this.tankCapacity = car.getFuelTankCapacity();

        this.maxDistancePerTank = tankCapacity * fuelEfficiency;
        this.pitStops = (int)Math.ceil(totalDistance / maxDistancePerTank) - 1;

        this.tyreWearPerLap = car.getTyre().getWearRate();
        this.tyreLifespan = (int)(1.0 / tyreWearPerLap);

        if (weather.equalsIgnoreCase("wet")) {
            this.tyreLifespan = (int)(tyreLifespan * 0.7);
        }

        this.tyreChanges = (int)Math.ceil((double)laps / tyreLifespan) - 1;
        this.recommendedTyre = car.getTyre().getCompound();

        System.out.println("\n--- Race Strategy ---");
        System.out.printf("Track: %.1fkm x %d laps (Total: %.1fkm)%n", trackLengthKm, laps, totalDistance);
        System.out.printf("Estimated Fuel Stops: %d%n", Math.max(0, pitStops));
        System.out.printf("Estimated Tyre Changes: %d (Tyre lifespan: ~%d laps)%n", Math.max(0, tyreChanges), tyreLifespan);
        System.out.println("Recommended Tyre: " + recommendedTyre);
        System.out.println("Weather: " + weather);
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
