import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0, 14.210526315789474",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5, 17.416666666666668",
                "Standard, Hard, Low-Drag Kit, 125, 7.5, 22.500000000000004",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0, 17.647058823529413",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0, 21.65625"})
    @DisplayName("Total Fuel Efficiency Test")
    void getTotalFuelEfficiency(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling, double expected) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(expected, car.getTotalFuelEfficiency());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0, 78.0",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5, 55.0",
                "Standard, Hard, Low-Drag Kit, 125, 7.5, 142.0",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0, 82.0",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0, 108.0"})
    @DisplayName("Top Speed Test")
    void getTopSpeed(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling, double expected) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(expected, car.getTopSpeed());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0, 6",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5, 9",
                "Standard, Hard, Low-Drag Kit, 125, 7.5, 5",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0, 7",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0, 7"})
    @DisplayName("Cornering Ability Test")
    void getCorneringAbility(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling, int expected) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(expected, car.getCorneringAbility());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0, 6.5",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5, 7.75",
                "Standard, Hard, Low-Drag Kit, 125, 7.5, 6.25",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0, 6.5",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0, 7.5"})
    @DisplayName("Total Handling Test")
    void getTotalHandling(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling, double expected) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(expected , car.getTotalHandling());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0, 8",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5, 7",
                "Standard, Hard, Low-Drag Kit, 125, 7.5, 6",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0, 6",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0, 7"})
    @DisplayName("Acceleration Test")
    void getAcceleration(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling, int expected) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(expected, car.getAcceleration());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0, 100",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5, 75",
                "Standard, Hard, Low-Drag Kit, 125, 7.5, 125",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0, 150",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0, 50"})
    @DisplayName("Fuel Tank Capacity Test")
    void getFuelTankCapacity(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling, int expected) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(expected, car.getFuelTankCapacity());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5",
                "Standard, Hard, Low-Drag Kit, 125, 7.5",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0"})
    @DisplayName("Tyre Test")
    void getTyre(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(tyre, car.getTyre());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5",
                "Standard, Hard, Low-Drag Kit, 125, 7.5",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0"})
    @DisplayName("Engine Test")
    void getEngine(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(engine, car.getEngine());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0",
                "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5",
                "Standard, Hard, Low-Drag Kit, 125, 7.5",
                "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0",
                "Hybrid, Hard, Ground Effect Kit, 50, 8.0"})
    @DisplayName("AeroKit Test")
    void getAeroKit(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        assertEquals(aeroKit, car.getAeroKit());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged, Medium, Hybrid Kit, 100, 7.0, Turbocharged, Medium, Standard Kit, 100, 78, 14.21, 6.50",
            "Hybrid, Soft, Downforce-Focused Kit, 75, 6.5, Hybrid, Soft, Downforce-Focused Kit, 75, 55, 17.42, 7.75",
            "Standard, Hard, Low-Drag Kit, 125, 7.5, Standard, Hard, Low-Drag Kit, 125, 142, 22.50, 6.25",
            "notAnEngine, notATyre, Adjustable Aero Kit, 150, 6.0, Standard, Medium, Adjustable Aero Kit, 150, 82, 17.65, 6.50",
            "Hybrid, Hard, Ground Effect Kit, 50, 8.0, Hybrid, Hard, Ground Effect Kit, 50, 108, 21.66, 7.50"})
    @DisplayName("Car To String Test")
    void testToString(String engineType, String tyreType, String aeroKitType, int fuelTankCapacity, double baseHandling, String s1, String s2, String s3, String s4, String s5, String s6, String s7) {
        Engine engine = EngineFactory.create(engineType);
        Tyre tyre = TyreFactory.create(tyreType);
        AeroKit aeroKit = AeroKitFactory.create(aeroKitType);
        Car car = new Car(engine, tyre, aeroKit, fuelTankCapacity, baseHandling);
        String result = "Car[Engine=" + s1 + ", Tyre=" + s2 + ", AeroKit=" + s3 + ", FuelTank=" + s4 + "L, Speed=" + s5 + "km/h, Efficiency=" + s6 + "km/l, Handling=" + s7 + "/10]";
        assertEquals(result, car.toString());

    }
}