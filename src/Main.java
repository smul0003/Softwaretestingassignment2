import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Aero Kits
        List<AerodynamicKit> aeroKits = ComponentLibrary.getAeroKits();
        System.out.println("Select Aerodynamic Kit:");
        for (int i = 0; i < aeroKits.size(); i++) {
            System.out.println(i + 1 + ". " + aeroKits.get(i));
        }
        int aeroIdx = scanner.nextInt() - 1;

        // Engines
        List<Engine> engines = ComponentLibrary.getEngines();
        System.out.println("\nSelect Engine:");
        for (int i = 0; i < engines.size(); i++) {
            System.out.println(i + 1 + ". " + engines.get(i));
        }
        int engineIdx = scanner.nextInt() - 1;

        // Tyres
        List<Tyre> tyres = ComponentLibrary.getTyres();
        System.out.println("\nSelect Tyre:");
        for (int i = 0; i < tyres.size(); i++) {
            System.out.println(i + 1 + ". " + tyres.get(i));
        }
        int tyreIdx = scanner.nextInt() - 1;

        // Fuel Tank
        System.out.print("\nEnter fuel tank capacity (litres): ");
        int fuelTank = scanner.nextInt();

        Car car = new Car(engines.get(engineIdx), tyres.get(tyreIdx), aeroKits.get(aeroIdx), fuelTank);
        System.out.println("\nYour Car: " + car);

        // Race info
        System.out.print("\nEnter track length (km): ");
        double trackLength = scanner.nextDouble();
        System.out.print("Enter number of laps: ");
        int laps = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter weather (dry/wet): ");
        String weather = scanner.nextLine();

        // Optimise Strategy
        RaceStrategyOptimizer.generateStrategy(car, trackLength, laps, weather);

        scanner.close();
    }
}
