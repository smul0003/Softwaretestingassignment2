import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class TyreTest {

    @ParameterizedTest
    @CsvSource({"Soft, Soft", "Hard, Hard", "Medium, Medium", "notRealTyre, Medium"})
    @DisplayName("Compound Test")
    void getCompound(String compound, String expected) {
        Tyre tyre = TyreFactory.create(compound);
        assertEquals(expected, tyre.getCompound());
    }

    @ParameterizedTest
    @CsvSource({"Soft, 0.07", "Hard, 0.03", "Medium, 0.05", "notRealTyre, 0.05"})
    @DisplayName("Wear Rate Test")
    void getWearRate(String compound, double expected) {
        Tyre tyre = TyreFactory.create(compound);
        assertEquals(expected, tyre.getWearRate());
    }

    @ParameterizedTest
    @CsvSource({"Soft, 9", "Hard, 6", "Medium, 7", "notRealTyre, 7"})
    @DisplayName("Grip Test")
    void getGrip(String compound, int expected) {
        Tyre tyre = TyreFactory.create(compound);
        assertEquals(expected, tyre.getGrip());
    }

    @ParameterizedTest
    @CsvSource({"Soft, 0.95", "Hard, 1.05", "Medium, 1.00", "notRealTyre, 1.00"})
    @DisplayName("Fuel Efficiency Multiplier Test")
    void getFuelEfficiencyMultiplier(String compound, double expected) {
        Tyre tyre = TyreFactory.create(compound);
        assertEquals(expected, tyre.getFuelEfficiencyMultiplier());
    }

    @ParameterizedTest
    @CsvSource({"Soft, Soft, 0.07, 9, 0.95", "Hard, Hard, 0.03, 6, 1.05", "Medium, Medium, 0.05, 7, 1.0", "notRealTyre, Medium, 0.05, 7, 1.0"})
    @DisplayName("Tyre To String Test")
    void testToString(String compound, String s1, String s2, String s3, String s4) {
        Tyre tyre = TyreFactory.create(compound);
        String expected = s1 + " [WearRate=" + s2 + ", Grip=" + s3 + ", EffMult=" + s4 + "]";
        assertEquals(expected, tyre.toString());
    }
}