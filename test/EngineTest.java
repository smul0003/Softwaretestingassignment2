import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {


    @ParameterizedTest
    @CsvSource({"Turbocharged, Turbocharged", "Hybrid, Hybrid", "Standard, Standard", "notAnEngine, Standard"})
    @DisplayName("Engine Type Test")
    void getType(String type, String expected) {
        Engine engine = EngineFactory.create(type);
        assertEquals(expected, engine.getType());

    }

    @ParameterizedTest
    @CsvSource({"Turbocharged,300","Hybrid,250","Standard,200","notAnEngine,200"})
    @DisplayName("Power Test")
    void getPower(String type, int expected) {
        Engine engine = EngineFactory.create(type);
        assertEquals(expected,engine.getPower());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged,0.90","Hybrid,1.10","Standard,1.00","notAnEngine,1.00"})
    @DisplayName("Engine Fuel Efficiency Multiplier Test")
    void getFuelEfficiencyMultiplier(String type, double expected) {
        Engine engine = EngineFactory.create(type);
        assertEquals(expected,engine.getFuelEfficiencyMultiplier());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged,8","Hybrid,7","Standard,6","notAnEngine,6"})
    @DisplayName("Acceleration Test")
    void getAcceleration(String type, int expected) {
        Engine engine = EngineFactory.create(type);
        assertEquals(expected,engine.getAcceleration());
    }

    @ParameterizedTest
    @CsvSource({"Turbocharged,Turbocharged, 300, 0.9, 8","Hybrid,Hybrid,250,1.1,7","Standard,Standard,200,1.0,6","notAnEngine,Standard,200,1.0,6"})
    @DisplayName("Engine To String Test")
    void testToString(String type, String s1, String s2, String s3, String s4) {
        String expected = s1 + " [Power=" + s2 + "HP, Accel=" + s4 + ", EffMult=" + s3 + "]";
        Engine engine = EngineFactory.create(type);
        assertEquals(expected,engine.toString());
    }
}