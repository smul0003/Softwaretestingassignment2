import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RaceStrategyOptimizerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/race-strategy-test-data.csv", numLinesToSkip = 1)
    @DisplayName("Checks posibilities with expected answers")
    void generateStrategy(int kit, int engine, int tyre, int fuelTank, int trackLength, int laps, String weather, String expected) {
        List<AerodynamicKit> aeroKits = ComponentLibrary.getAeroKits();
        List<Engine> engines = ComponentLibrary.getEngines();
        List<Tyre> tyres = ComponentLibrary.getTyres();
        Car car = new Car(engines.get(engine-1), tyres.get(tyre-1), aeroKits.get(kit-1), fuelTank);
        RaceStrategyOptimizer.generateStrategy(car, trackLength, laps, weather);
        System.out.println(expected);
        //RaceStrategyOptimizer doesnt return anything so its hard to compare, chatgpt can be prompted to have a toString()
        //returned instead so its easier to use assertEquals
    }
}