import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by emilh on 04-11-2016.
 */
public class FieldTest {
    /**
     * Tests if the fields individual values can be fetched and are correct.
     * @throws Exception
     */
    @Test
    public void getScoreValue() throws Exception {

        assertEquals(250, Field.TOWER.getScoreValue());
        assertEquals(-100, Field.CRATER.getScoreValue());
        assertEquals(100, Field.PALACE_GATES.getScoreValue());
        assertEquals(-20, Field.COLD_DESERT.getScoreValue());
        assertEquals(180, Field.WALLED_CITY.getScoreValue());
        assertEquals(0, Field.MONASTERY.getScoreValue());
        assertEquals(-70, Field.BLACK_CAVE.getScoreValue());
        assertEquals(60, Field.HUTS_IN_THE_MOUNTAIN.getScoreValue());
        assertEquals(-80, Field.THE_WEREWALL.getScoreValue());
        assertEquals(-50, Field.THE_PIT.getScoreValue());
        assertEquals(650, Field.GOLDMINE.getScoreValue());
    }
}