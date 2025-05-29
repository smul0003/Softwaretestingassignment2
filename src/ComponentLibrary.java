import java.util.*;

public class ComponentLibrary {
    public static List<AerodynamicKit> getAeroKits() {
        List<AerodynamicKit> list = new ArrayList<>();
        list.add(new AerodynamicKit("Standard Kit", 0.30, 200, 250, 12, 6));
        list.add(new AerodynamicKit("Downforce-Focussed Kit", 0.35, 350, 220, 10, 9));
        list.add(new AerodynamicKit("Low-Drag Kit", 0.25, 150, 280, 14, 5));
        list.add(new AerodynamicKit("Adjustable Aero Kit", 0.31, 250, 250, 12, 8));
        list.add(new AerodynamicKit("Ground Effect Kit", 0.27, 400, 240, 12, 8));
        list.add(new AerodynamicKit("Drag Reduction System Kit", 0.25, 200, 290, 13, 6));
        list.add(new AerodynamicKit("Wet Weather Kit", 0.32, 220, 230, 11, 7));
        list.add(new AerodynamicKit("Hybrid Kit", 0.29, 260, 260, 12, 7));
        list.add(new AerodynamicKit("Extreme Aero Kit", 0.4, 500, 200, 9, 10));
        return list;
    }

    public static List<Engine> getEngines() {
        return Arrays.asList(
                new Engine("Standard", 200, 1.0, 6),
                new Engine("Turbocharged", 300, 0.9, 8),
                new Engine("Hybrid", 250, 1.1, 7)
        );
    }

    public static List<Tyre> getTyres() {
        return Arrays.asList(
                new Tyre("Soft", 0.07, 9, 0.95),
                new Tyre("Medium", 0.05, 7, 1.0),
                new Tyre("Hard", 0.03, 6, 1.05)
        );
    }
}
