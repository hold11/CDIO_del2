import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by awo on 11/10/16.
 */
public class AppTest {
    @Test
    public void add() throws Exception {
        int r1, r2, r3;
        r1 = App.add(5, 4);
        r2 = App.add(7, 4);
        r3 = App.add(1, 9);

        assertEquals(9,  r1);
        assertEquals(11, r2);
        assertEquals(10, r3);
    }

}