public class EngineFactory {

    public static Engine create(String type) {
        return switch (type) {
            case "Turbocharged" ->
                // type, power (HP), fuel-efficiency multiplier, acceleration rating
                    new Engine("Turbocharged", 300, 0.90, 8);
            case "Hybrid" ->
                    new Engine("Hybrid", 250, 1.10, 7);
            default -> // “Standard”
                    new Engine("Standard", 200, 1.00, 6);
        };
    }
}
