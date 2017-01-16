package FirstAttempt;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aunk05 on 15/01/17.
 */
public class TestSuite {

    Arabizer arabizer = new Arabizer();

    @Test
    public void testOneMString() {
        assertEquals(arabizer.convert("M"), 1000);

    }

    @Test
    public void testArbitraryMString() {
        assertEquals(arabizer.convert("MM"), 2000);
    }

    @Test
    public void testArbitraryString() {

        assertEquals(arabizer.convert("MMDD"), 3000);

    }

    @Test
    public void testWithSubtraction() {

        assertEquals(arabizer.convert("MCM"), 1900);
        assertEquals(arabizer.convert("MCMLXXXVIII"), 1988);
        assertEquals(arabizer.convert("MCMXCIX"), 1999);

    }
}
