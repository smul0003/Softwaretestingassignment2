public class Car {
    private Engine engine;
    private Tyre tyre;
    private AerodynamicKit aeroKit;
    private int fuelTankCapacity; // litres

    public Car(Engine engine, Tyre tyre, AerodynamicKit aeroKit, int fuelTankCapacity) {
        this.engine = engine;
        this.tyre = tyre;
        this.aeroKit = aeroKit;
        this.fuelTankCapacity = fuelTankCapacity;
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
    public Tyre getTyre() {
        return tyre;
    }

    public int getCorneringAbility() {
        return Math.min(10, (int)((aeroKit.getCorneringAbility() + tyre.getGrip()) / 2));
    }

    public int getAcceleration() {
        return engine.getAcceleration();
    }

    public int getFuelTankCapacity() {
        return fuelTankCapacity;
    }

    @Override
    public String toString() {
        return "Car [Engine=" + engine + ", Tyre=" + tyre + ", AeroKit=" + aeroKit
                + ", FuelTank=" + fuelTankCapacity + "L]";
    }
}
