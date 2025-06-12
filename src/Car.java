public class Car {
    private Engine engine;
    private Tyre tyre;
    private AeroKit aeroKit;
    private int fuelTankCapacity; // litres
    private double baseHandling;

    public Car(Engine engine, Tyre tyre, AeroKit aeroKit, int fuelTankCapacity, double baseHandling) {
        this.engine = engine;
        this.tyre = tyre;
        this.aeroKit = aeroKit;
        this.fuelTankCapacity = fuelTankCapacity;
        this.baseHandling = baseHandling;
    }

    public double getTotalFuelEfficiency() {
        return aeroKit.getFuelEfficiencyKmpl()
                * engine.getFuelEfficiencyMultiplier()
                * tyre.getFuelEfficiencyMultiplier();
    }

    public int getTopSpeed() {
        return Math.min(
                (int)(aeroKit.getTopSpeedKmh() * (engine.getPower() / 200.0)),
                350
        );
    }

    public int getCorneringAbility() {
        return Math.min(10, (int)((aeroKit.getCorneringAbility() + tyre.getGrip()) / 2));
    }

    public double getTotalHandling() {
        return Math.min(10.0, (getCorneringAbility() + baseHandling) / 2.0);
    }

    public int getAcceleration() {
        return engine.getAcceleration();
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    public Tyre getTyre() {
        return tyre;
    }

    public Engine getEngine() {
        return engine;
    }

    public AeroKit getAeroKit() {
        return aeroKit;
    }

    @Override
    public String toString() {
        return String.format(
                "Car[Engine=%s, Tyre=%s, AeroKit=%s, FuelTank=%dL, Speed=%dkm/h, Efficiency=%.2fkm/l, Handling=%.2f/10]",
                engine.getType(),
                tyre.getCompound(),
                aeroKit.getName(),
                fuelTankCapacity,
                getTopSpeed(),
                getTotalFuelEfficiency(),
                getTotalHandling()
        );
    }
}
