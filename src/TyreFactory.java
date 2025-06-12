public class TyreFactory {

    public static Tyre create(String compound) {
        return switch (compound) {
            case "Soft"  -> new Tyre("Soft", 0.07, 9, 0.95);
            case "Hard"  -> new Tyre("Hard", 0.03, 6, 1.05);
            default      -> new Tyre("Medium", 0.05, 7, 1.00); // “Medium”
        };
    }
}
