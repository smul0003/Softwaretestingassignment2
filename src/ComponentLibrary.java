import java.util.*;

public class ComponentLibrary {
    public static List<AeroKit> getAeroKits() {
        List<AeroKit> list = new ArrayList<>();
        list.add(new AeroKit("Standard Kit", 0.30, 200, 250, 12, 6));
        list.add(new AeroKit("Downforce-Focussed Kit", 0.35, 350, 220, 10, 9));
        list.add(new AeroKit("Low-Drag Kit", 0.25, 150, 280, 14, 5));
        list.add(new AeroKit("Adjustable Aero Kit", 0.31, 250, 250, 12, 8));
        list.add(new AeroKit("Ground Effect Kit", 0.27, 400, 240, 12, 8));
        list.add(new AeroKit("Drag Reduction System Kit", 0.25, 200, 290, 13, 6));
        list.add(new AeroKit("Wet Weather Kit", 0.32, 220, 230, 11, 7));
        list.add(new AeroKit("Hybrid Kit", 0.29, 260, 260, 12, 7));
        list.add(new AeroKit("Extreme Aero Kit", 0.4, 500, 200, 9, 10));
        return list;
    }

}
