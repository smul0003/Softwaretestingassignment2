import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;

class AeroKitTest {
    List<AeroKit> aeroKits = ComponentLibrary.getAeroKits();
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
            "Standard Kit, 0.95, 5, 5, 5,5",
            "Downforce-Focused Kit,0.90,9,10,4,2",
            "Low-Drag Kit, 0.70, 3, 4, 10, 3",
            "Adjustable Aero Kit, 0.85, 7, 7, 7, 9",
            "Ground Effect Kit, 0.80, 10, 9, 7, 4",

    })
    @DisplayName("AerokitFactory Create test")
    void create(String name, String dragCoefficient, String downforceRating, String corneringAbility, String straightLineSpeed, String flexibility) {
        AeroKit kit = AeroKitFactory.create(name);

        double drag = Double.parseDouble(dragCoefficient);
        int downForce = Integer.parseInt(downforceRating);
        int cornering = Integer.parseInt(corneringAbility);
        int straight = Integer.parseInt(straightLineSpeed);
        int flex = Integer.parseInt(flexibility);

        assertAll(
                () -> assertEquals(name, kit.getName()),
                () -> assertEquals(drag, kit.getDragCoefficient()),
                () -> assertEquals(downForce, kit.getDownforceRating()),
                () -> assertEquals(cornering, kit.getCorneringAbility()),
                () -> assertEquals(straight, kit.getStraightLineSpeed()),
                () -> assertEquals(flex, kit.getFlexibility())
        );

    }
    @ParameterizedTest
    @CsvSource({
            "Standard Kit, 0.95, 5, 5, 5,5",
            "Downforce-Focused Kit,0.90,9,10,4,2",
            "Low-Drag Kit, 0.70, 3, 4, 10, 3",
            "Adjustable Aero Kit, 0.85, 7, 7, 7, 9",
            "Ground Effect Kit, 0.80, 10, 9, 7, 4",

    })
    @DisplayName("Aerokit Create test")
    void AerokitInsertTest(String name, String dragCoefficient, String downforceRating, String corneringAbility, String straightLineSpeed, String flexibility) {


        double drag = Double.parseDouble(dragCoefficient);
        int downForce = Integer.parseInt(downforceRating);
        int cornering = Integer.parseInt(corneringAbility);
        int straight = Integer.parseInt(straightLineSpeed);
        int flex = Integer.parseInt(flexibility);
        AeroKit kit = new AeroKit(name, drag,downForce, cornering, straight, flex);
        assertAll(
                () -> assertEquals(name, kit.getName()),
                () -> assertEquals(drag, kit.getDragCoefficient()),
                () -> assertEquals(downForce, kit.getDownforceRating()),
                () -> assertEquals(cornering, kit.getCorneringAbility()),
                () -> assertEquals(straight, kit.getStraightLineSpeed()),
                () -> assertEquals(flex, kit.getFlexibility())
        );

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
    @DisplayName("DownforceKG test")
    void getDownforceKg(String ind, String downForce) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

        int dfKG = Integer.parseInt(downForce);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(dfKG, aeroKits.get(index).getDownforceRating())
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
    @DisplayName("StraightLineSpeed test")
    void straightLine(String ind, String straightLine) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

            int tS = Integer.parseInt(straightLine);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(tS, aeroKits.get(index).getStraightLineSpeed())
            );


        }
    }
    @ParameterizedTest
    @CsvSource({
            "0, 400",
            "1, 285",
            "2, 560",
            "3, 387",
            "4, 444",
            "5, 520",
            "6, 343",
            "7, 413",
            "8, 225",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("TopSpeed test")
    void topSpeed(String ind, String topSpeed) {
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
            "0, 50.0",
            "1, 42.85714285714286",
            "2, 60.0",
            "3, 48.38709677419355",
            "4, 55.55555555555555",
            "5, 60.0",
            "6, 46.875",
            "7, 51.724137931034484",
            "8, 37.5",
            "9, NA",
            "-4, NA"
    })
    @DisplayName("FuelEfficiency test")
    void fuelEfficiency(String ind, String fuelEffiency) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

            double tS = Double.parseDouble(fuelEffiency);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(tS, aeroKits.get(index).getFuelEfficiencyKmpl())
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
    @DisplayName("Flexibility test")
    void getFlexibility(String ind, String flexibility) {
        int index = Integer.parseInt(ind);

        if(index>8 || index<0){
            assertThrows(IndexOutOfBoundsException.class, () -> aeroKits.get(index));
        }else{

            int fuelEff = Integer.parseInt(flexibility);
            assertAll(
                    () ->assertDoesNotThrow(() -> (aeroKits.get(index))),
                    () ->assertEquals(fuelEff, aeroKits.get(index).getFlexibility())
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
            "0, 'Standard Kit: Drag=0.3, Downforce=200, Cornering=250, StraightLine=12, Flexibility=6'",
            "1, 'Downforce-Focussed Kit: Drag=0.35, Downforce=350, Cornering=220, StraightLine=10, Flexibility=9'",
            "2, 'Low-Drag Kit: Drag=0.25, Downforce=150, Cornering=280, StraightLine=14, Flexibility=5'",
            "3, 'Adjustable Aero Kit: Drag=0.31, Downforce=250, Cornering=250, StraightLine=12, Flexibility=8'",
            "4, 'Ground Effect Kit: Drag=0.27, Downforce=400, Cornering=240, StraightLine=12, Flexibility=8'",
            "5, 'Drag Reduction System Kit: Drag=0.25, Downforce=200, Cornering=290, StraightLine=13, Flexibility=6'",
            "6, 'Wet Weather Kit: Drag=0.32, Downforce=220, Cornering=230, StraightLine=11, Flexibility=7'",
            "7, 'Hybrid Kit: Drag=0.29, Downforce=260, Cornering=260, StraightLine=12, Flexibility=7'",
            "8, 'Extreme Aero Kit: Drag=0.4, Downforce=500, Cornering=200, StraightLine=9, Flexibility=10'",
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