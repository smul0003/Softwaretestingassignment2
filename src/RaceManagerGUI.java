import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RaceManagerGUI extends JFrame {

    private JComboBox<String> engineBox, tyreBox, aeroBox, weatherBox;
    private JTextField trackLengthField, lapsField;
    private JTextArea outputArea;

    public RaceManagerGUI() {
        setTitle("Race Strategy Optimiser & Car Customisation Tool");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // NORTH PANEL – Form Inputs
        JPanel inputPanel = new JPanel(new GridLayout(6, 2, 10, 10));
        engineBox = new JComboBox<>(new String[]{"Standard", "Turbocharged", "Hybrid"});
        tyreBox = new JComboBox<>(new String[]{"Soft", "Medium", "Hard"});
        aeroBox = new JComboBox<>(new String[]{
                "Standard Kit", "Downforce-Focused Kit", "Low-Drag Kit", "Adjustable Aero Kit"
        });
        weatherBox = new JComboBox<>(new String[]{"Clear", "Wet"});

        trackLengthField = new JTextField("5.0");
        lapsField = new JTextField("20");

        inputPanel.setBorder(BorderFactory.createTitledBorder("Race Setup"));

        inputPanel.add(new JLabel("Engine Type:"));
        inputPanel.add(engineBox);
        inputPanel.add(new JLabel("Tyre Compound:"));
        inputPanel.add(tyreBox);
        inputPanel.add(new JLabel("Aerodynamic Kit:"));
        inputPanel.add(aeroBox);
        inputPanel.add(new JLabel("Track Length (km):"));
        inputPanel.add(trackLengthField);
        inputPanel.add(new JLabel("Number of Laps:"));
        inputPanel.add(lapsField);
        inputPanel.add(new JLabel("Weather:"));
        inputPanel.add(weatherBox);

        add(inputPanel, BorderLayout.NORTH);

        // CENTER PANEL – Output Display
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        // SOUTH PANEL – Buttons
        JPanel buttonPanel = new JPanel();
        JButton customiseBtn = new JButton("Customise Car");
        JButton strategyBtn = new JButton("Generate Strategy");

        buttonPanel.add(customiseBtn);
        buttonPanel.add(strategyBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        // Button Actions
        customiseBtn.addActionListener(e -> customiseCar());
        strategyBtn.addActionListener(e -> generateStrategy());
    }

    private Car currentCar;

    private void customiseCar() {
        Engine engine = EngineFactory.create(engineBox.getSelectedItem().toString());
        Tyre tyre = TyreFactory.create(tyreBox.getSelectedItem().toString());
        AeroKit aeroKit = AeroKitFactory.create(aeroBox.getSelectedItem().toString());
        currentCar = new Car(engine, tyre, aeroKit, 100, 7.0);

        outputArea.setText("Car Customised:\n" + currentCar.toString());
    }

    public static String generateStrategy(Car car, double trackLength, int laps, String weather) {
        double totalDistance = trackLength * laps;
        double fuelEfficiency = car.getTotalFuelEfficiency();
        int tankCapacity = car.getFuelTankCapacity();
        double totalFuelRequired = totalDistance / fuelEfficiency;
        int numberOfFuelStops = (int) Math.ceil(totalFuelRequired / tankCapacity);

        double tyreWearRate = car.getTyre().getWearRate();
        int tyreDurability = (int) (100 / (tyreWearRate * 100));
        int numberOfTyreChanges = (int) Math.ceil((double) laps / tyreDurability);

        String recommendedTyreStrategy;
        if (weather.equalsIgnoreCase("rainy")) {
            recommendedTyreStrategy = "Wet Tyres Recommended";
        } else if (weather.equalsIgnoreCase("hot")) {
            recommendedTyreStrategy = "Hard Tyres Recommended";
        } else {
            recommendedTyreStrategy = "Medium Tyres Recommended";
        }

        return String.format(
                "FuelStops=%d, TyreChanges=%d, RecommendedTyre=%s, FuelRequired=%.2fL, Efficiency=%.2fkm/L",
                numberOfFuelStops,
                numberOfTyreChanges,
                recommendedTyreStrategy,
                totalFuelRequired,
                fuelEfficiency
        );
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RaceManagerGUI().setVisible(true));
    }
}
