package Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.launchcode.techjobs_oo.*;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class JobTest {
    static Job o1;
    static Job o2;
    static Job o3;
    static Job o4;
    static Job o5;
    static Job o6;
    static Job o7;

    @BeforeAll
    public static void setup() {
        o1 = new Job();
        o2 = new Job();
        o3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        o4 = new Job("Product tester", new Employer("ACME"), new Location(
                "Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        o5 = new Job("Test", new Employer("Test Start Up"), new Location(
                "Test Field, MO"), new PositionType("Tester"),
                new CoreCompetency("Testing"));
        o6 = new Job("Test", new Employer("Test Start Up"), new Location(
                "Test Field, MO"), new PositionType("Tester"),
                new CoreCompetency("Testing"));
        o7 = new Job();
    }

    @Test
    public void defaultConstructorTest() {
        assertEquals(7, o7.getId());
    }

    @Test
    public void checkIDs() {
        assertEquals(1, o1.getId());
        assertEquals(2, o2.getId());
    }

    @Test
    public void doesNotMatch() {
        assertFalse(o1.equals(o2));
        assertFalse(o3.equals(o4));
    }

    @Test
    public void doesMatch() {
        assertTrue(o1.equals(o1));
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(o3 instanceof Job);
        assertTrue(o3.getEmployer() instanceof Employer);
        assertTrue(o3.getLocation() instanceof Location);
        assertTrue(o3.getPositionType() instanceof PositionType);
        assertTrue(o3.getCoreCompetency() instanceof CoreCompetency);
    }

    @Test
    public void buildToStringTest() {

        String expected =
                "\n" +
                "ID:  6\n" +
                "Name: Test\n" +
                "Employer: Test Start Up\n" +
                "Location: Test Field, MO\n" +
                "Position Type: Tester\n" +
                "Core Competency: Testing\n";
        assertEquals(expected, o6.toString());
    }

    @Test
    public void toStringMissingFieldsNull() {
        o1.setEmployer(new Employer("King Bishop"));
        String expected =
                "\n" +
                "ID:  1\n" +
                "Name: Data not available\n" +
                "Employer: King Bishop\n" +
                "Location: Data not available\n" +
                "Position Type: Data not available\n" +
                "Core Competency: Data not available\n";
        assertEquals(expected, o1.toString());
    }

    @Test
    public void toStringMissingFieldsEmpty() {
        o5.setEmployer(new Employer (""));
        o5.setLocation(new Location(""));
        o5.setCoreCompetency(new CoreCompetency(""));
        o5.setName("");
        o5.setPositionType(new PositionType(""));

        String expected =
                "\n" +
                        "ID:  5\n" +
                        "Name: Data not available\n" +
                        "Employer: Data not available\n" +
                        "Location: Data not available\n" +
                        "Position Type: Data not available\n" +
                        "Core Competency: Data not available\n";
        assertEquals(expected, o5.toString());
    }

    @Test
    public void testFirstAndLastChar() {
        char[] charArray = o6.toString().toCharArray();
        String firstCharacter = Character.toString(charArray[0]);
        String lastCharacter =
                Character.toString(charArray[charArray.length -1]);
        assertEquals("\n", firstCharacter);
        assertEquals("\n", lastCharacter);
    }

    @Test
    public void onlyID() {
        assertEquals("OOPS! This job does not seem to exist.", o2.toString());
    }

}
