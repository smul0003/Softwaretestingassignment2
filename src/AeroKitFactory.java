public class AeroKitFactory {
    public static AeroKit create(String name) {
        return switch (name) {
            case "Downforce-Focused Kit" -> new AeroKit(name, 0.90, 9, 10, 4, 2);
            case "Low-Drag Kit"          -> new AeroKit(name, 0.70, 3, 4, 10, 3);
            case "Adjustable Aero Kit"   -> new AeroKit(name, 0.85, 7, 7, 7, 9);
            case "Ground Effect Kit"     -> new AeroKit(name, 0.80, 10, 9, 7, 4);
            default                      -> new AeroKit("Standard Kit", 0.95, 5, 5, 5, 5);
        };
    }
}
