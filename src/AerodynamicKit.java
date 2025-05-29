public class AerodynamicKit {
    private final String name;
    private final double dragCoefficient;
    private final int downforceKg;
    private final int topSpeedKmh;
    private final int fuelEfficiencyKmpl;
    private final int corneringAbility; // out of 10

    public AerodynamicKit(String name, double dragCoefficient, int downforceKg, int topSpeedKmh, int fuelEfficiencyKmpl, int corneringAbility) {
        this.name = name;
        this.dragCoefficient = dragCoefficient;
        this.downforceKg = downforceKg;
        this.topSpeedKmh = topSpeedKmh;
        this.fuelEfficiencyKmpl = fuelEfficiencyKmpl;
        this.corneringAbility = corneringAbility;
    }

    public String getName() { return name; }
    public double getDragCoefficient() { return dragCoefficient; }
    public int getDownforceKg() { return downforceKg; }
    public int getTopSpeedKmh() { return topSpeedKmh; }
    public int getFuelEfficiencyKmpl() { return fuelEfficiencyKmpl; }
    public int getCorneringAbility() { return corneringAbility; }

    @Override
    public String toString() {
        return name + " [Cd=" + dragCoefficient + ", Downforce=" + downforceKg + "kg, TopSpeed=" + topSpeedKmh +
                "km/h, FuelEff=" + fuelEfficiencyKmpl + "km/l, Cornering=" + corneringAbility + "]";
    }
}
