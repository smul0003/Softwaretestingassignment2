import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.*;
class RaceStrategyOptimizerTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/race-strategy-test-data.csv", numLinesToSkip = 1, delimiter =';')
    @DisplayName("Checks posibilities with expected answers")
    void generateStrategy(String Engine, String Tyre, String aerokit, int fuel, double base, double track, int laps, String weather, String expected) {
        Engine engine = EngineFactory.create(Engine);
        Tyre tyre = TyreFactory.create(Tyre);
        AeroKit aeroKit = AeroKitFactory.create(aerokit);

        Car car = new Car(engine, tyre,aeroKit,fuel,base);
        String strategy = RaceStrategyOptimizer.generateStrategy(car, track, laps, weather);
        assertEquals(expected, strategy);

    }
}