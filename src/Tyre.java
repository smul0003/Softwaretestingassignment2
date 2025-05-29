public class Tyre {
    private final String compound;
    private final double wearRate; // % per lap
    private final int grip; // 1-10
    private final double fuelEfficiencyMultiplier;

    public Tyre(String compound, double wearRate, int grip, double fuelEfficiencyMultiplier) {
        this.compound = compound;
        this.wearRate = wearRate;
        this.grip = grip;
        this.fuelEfficiencyMultiplier = fuelEfficiencyMultiplier;
    }

    public String getCompound() { return compound; }
    public double getWearRate() { return wearRate; }
    public int getGrip() { return grip; }
    public double getFuelEfficiencyMultiplier() { return fuelEfficiencyMultiplier; }

    @Override
    public String toString() {
        return compound + " [WearRate=" + wearRate + ", Grip=" + grip + ", EffMult=" + fuelEfficiencyMultiplier + "]";
    }
}
