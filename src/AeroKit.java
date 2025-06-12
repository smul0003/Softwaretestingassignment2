public class AeroKit {
    private String name;
    private double dragCoefficient; // e.g., 0.70 (low drag), 0.95 (high drag)
    private int downforceRating;
    private int corneringAbility;
    private int straightLineSpeed;
    private int flexibility;

    public AeroKit(String name, double dragCoefficient, int downforceRating,
                   int corneringAbility, int straightLineSpeed, int flexibility) {
        this.name = name;
        this.dragCoefficient = dragCoefficient;
        this.downforceRating = downforceRating;
        this.corneringAbility = corneringAbility;
        this.straightLineSpeed = straightLineSpeed;
        this.flexibility = flexibility;
    }

    // ⛽ Derived Fuel Efficiency based on Drag Coefficient
    public double getFuelEfficiencyKmpl() {
        // Lower drag = higher fuel efficiency. Arbitrary scaling factor.
        return 15.0 / dragCoefficient; // For example: 15 / 0.75 = 20 km/l
    }

    public int getTopSpeedKmh() {
        // Base top speed modified by aero rating and drag
        return (int)(straightLineSpeed * (1.0 / dragCoefficient) * 10);
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getDragCoefficient() {
        return dragCoefficient;
    }

    public int getDownforceRating() {
        return downforceRating;
    }

    public int getCorneringAbility() {
        return corneringAbility;
    }

    public int getStraightLineSpeed() {
        return straightLineSpeed;
    }

    public int getFlexibility() {
        return flexibility;
    }

    @Override
    public String toString() {
        return name + ": Drag=" + dragCoefficient +
                ", Downforce=" + downforceRating +
                ", Cornering=" + corneringAbility +
                ", StraightLine=" + straightLineSpeed +
                ", Flexibility=" + flexibility;
    }
}
