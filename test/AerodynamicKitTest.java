import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class AerodynamicKitTest {
    List<AerodynamicKit> aeroKits = ComponentLibrary.getAeroKits();
    @ParameterizedTest
    @CsvSource({
            "0, Standard Kit",
            "1, Downforce-Focussed Kit",
            "2, Low-Drag Kit",
            "3, Adjustable Aero Kit",
            "4, Ground Effect Kit",
            "5, Drag Reduction System Kit",
            "6, Wet Weather Kit",
            "7, Hybrid Kit",
            "8, Extreme Aero Kit",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("Get name tested with three asserts")
    void getName(String ind, String expected) {
        int index = Integer.parseInt(ind);
        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> {aeroKits.get(index);});
        }else{
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(expected, aeroKits.get(index).getName())
            );


        }
    }

    @Test
    void getDragCoefficient() {
    }

    @Test
    void getDownforceKg() {
    }

    @Test
    void getTopSpeedKmh() {
    }

    @Test
    void getFuelEfficiencyKmpl() {
    }

    @Test
    void getCorneringAbility() {
    }

    @Test
    void testToString() {
    }
}