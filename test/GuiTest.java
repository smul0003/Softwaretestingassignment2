import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
//Need to download library, in this case maven is used with dependency:
/*
<dependency>
<groupId>org.assertj</groupId>
<artifactId>assertj-swing-junit</artifactId>
<version>3.17.1</version>
<scope>test</scope>
</dependency>
 */


public class GuiTest {
    private FrameFixture window;
    @BeforeAll
    static void setupOnce(){
        FailOnThreadViolationRepaintManager.install();
    }
    @BeforeEach
    void setUp(){

        RaceManagerGUI frame = GuiActionRunner.execute(RaceManagerGUI::new);
        window = new FrameFixture(frame);
        window.show();

    }

    @AfterEach
    void tearDown(){
        window.cleanUp();
    }

    @Test
    void testCustomiseButtons(){
        window.comboBox("engineBox").selectItem("Turbocharged");
        window.comboBox("tyreBox").selectItem("Medium");
        window.comboBox("aeroBox").selectItem("Standard Kit");

        window.button(JButtonMatcher.withText("Customise Car")).click();

        String output = window.textBox("outputArea").text();
        Assertions.assertTrue(output.contains("Car Customised"));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/race-strategy-test-data.csv", numLinesToSkip = 1, delimiter =';')
    @DisplayName("Checks posibilities with expected answers")
    void generateStrategy(String Engine, String Tyre, String aerokit, int fuel, double base, double track, int laps, String weather, String expected) {
        Engine engine = EngineFactory.create(Engine);
        Tyre tyre = TyreFactory.create(Tyre);
        AeroKit aeroKit = AeroKitFactory.create(aerokit);

        Car car = new Car(engine, tyre,aeroKit,fuel,base);
        String strategy = RaceManagerGUI.generateStrategy(car, track, laps, weather);
        assertEquals(expected, strategy);

    }
}
