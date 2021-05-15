package Test;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.launchcode.techjobs_oo.Employer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployerTest {
    static Employer empObj;
    @BeforeAll
    public static void setup() {
        empObj = new Employer();
    }

    @Test
    public void checkID() {
        assertEquals(1, empObj.getId());
    }
}
