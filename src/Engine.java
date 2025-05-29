public class Engine {
    private final String type;
    private final int power; // in HP
    private final double fuelEfficiencyMultiplier;
    private final int acceleration; // arbitrary unit

    public Engine(String type, int power, double fuelEfficiencyMultiplier, int acceleration) {
        this.type = type;
        this.power = power;
        this.fuelEfficiencyMultiplier = fuelEfficiencyMultiplier;
        this.acceleration = acceleration;
    }

    public String getType() { return type; }
    public int getPower() { return power; }
    public double getFuelEfficiencyMultiplier() { return fuelEfficiencyMultiplier; }
    public int getAcceleration() { return acceleration; }

    @Override
    public String toString() {
        return type + " [Power=" + power + "HP, Accel=" + acceleration + ", EffMult=" + fuelEfficiencyMultiplier + "]";
    }
}
