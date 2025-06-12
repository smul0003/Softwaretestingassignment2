import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;


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
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(expected, aeroKits.get(index).getName())
            );


        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 0.3",
            "1, 0.35",
            "2, 0.25",
            "3, 0.31",
            "4, 0.27",
            "5, 0.25",
            "6, 0.32",
            "7, 0.29",
            "8, 0.4",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("DragCoefficient test")
    void getDragCoefficient(String ind, String dragCoEfficient) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{
            double drag = Double.parseDouble(dragCoEfficient);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(drag, aeroKits.get(index).getDragCoefficient())
            );


        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 200",
            "1, 350",
            "2, 150",
            "3, 250",
            "4, 400",
            "5, 200",
            "6, 220",
            "7, 260",
            "8, 500",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("DragCoefficient test")
    void getDownforceKg(String ind, String downForce) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

        int dfKG = Integer.parseInt(downForce);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(dfKG, aeroKits.get(index).getDownforceKg())
            );


        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 250",
            "1, 220",
            "2, 280",
            "3, 250",
            "4, 240",
            "5, 290",
            "6, 230",
            "7, 260",
            "8, 200",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("TopSpeed test")
    void getTopSpeedKmh(String ind, String topSpeed) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

            int tS = Integer.parseInt(topSpeed);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(tS, aeroKits.get(index).getTopSpeedKmh())
            );


        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 12",
            "1, 10",
            "2, 14",
            "3, 12",
            "4, 12",
            "5, 13",
            "6, 11",
            "7, 12",
            "8, 9",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("FuelEfficiency test")
    void getFuelEfficiencyKmpl(String ind, String fuelEfficiency) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

            int fuelEff = Integer.parseInt(fuelEfficiency);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(fuelEff, aeroKits.get(index).getFuelEfficiencyKmpl())
            );


        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 6",
            "1, 9",
            "2, 5",
            "3, 8",
            "4, 8",
            "5, 6",
            "6, 7",
            "7, 7",
            "8, 10",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("Cornering Ability test")
    void getCorneringAbility(String ind, String corneringAbility) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

            int cornering = Integer.parseInt(corneringAbility);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(cornering, aeroKits.get(index).getCorneringAbility())
            );


        }
    }

    @ParameterizedTest
    @CsvSource({
            "0, 'Standard Kit [Cd=0.3, Downforce=200kg, TopSpeed=250km/h, FuelEff=12km/l, Cornering=6]'",
            "1, 'Downforce-Focussed Kit [Cd=0.35, Downforce=350kg, TopSpeed=220km/h, FuelEff=10km/l, Cornering=9]'",
            "2, 'Low-Drag Kit [Cd=0.25, Downforce=150kg, TopSpeed=280km/h, FuelEff=14km/l, Cornering=5]'",
            "3, 'Adjustable Aero Kit [Cd=0.31, Downforce=250kg, TopSpeed=250km/h, FuelEff=12km/l, Cornering=8]'",
            "4, 'Ground Effect Kit [Cd=0.27, Downforce=400kg, TopSpeed=240km/h, FuelEff=12km/l, Cornering=8]'",
            "5, 'Drag Reduction System Kit [Cd=0.25, Downforce=200kg, TopSpeed=290km/h, FuelEff=13km/l, Cornering=6]'",
            "6, 'Wet Weather Kit [Cd=0.32, Downforce=220kg, TopSpeed=230km/h, FuelEff=11km/l, Cornering=7]'",
            "7, 'Hybrid Kit [Cd=0.29, Downforce=260kg, TopSpeed=260km/h, FuelEff=12km/l, Cornering=7]'",
            "8, 'Extreme Aero Kit [Cd=0.4, Downforce=500kg, TopSpeed=200km/h, FuelEff=9km/l, Cornering=10]'",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("toString test")
    void testToString(String ind, String expected) {
        int index = Integer.parseInt(ind);
        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(expected, aeroKits.get(index).toString())
            );


        }
    }
}