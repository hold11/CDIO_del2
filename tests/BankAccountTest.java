import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by emilh on 02-11-2016.
 */
public class BankAccountTest {
    private BankAccount playerAccount;
    private Player p1, p2;

    @Before
    public void setUp() throws Exception {
        p1 = new Player();
        p2 = new Player();


    }

    @After
    public void tearDown() throws Exception {
        Player.reset();


    }

    @Test
    public void setBalance() throws Exception {
        p1.getPlayerAccount().setBalance(100);
        p2.getPlayerAccount().setBalance(250);

        assertEquals(100, p1.getPlayerAccount().getBalance());
        assertEquals(250, p2.getPlayerAccount().getBalance());

    }

    @Test
    public void getBalance() throws Exception {
        assertEquals(1000, p1.getPlayerAccount().getBalance());
        assertEquals(1000, p2.getPlayerAccount().getBalance());

    }

    @Test
    public void deposit() throws Exception {
        p1.getPlayerAccount().deposit(200);
        p2.getPlayerAccount().deposit(300);

        assertEquals(1200, p1.getPlayerAccount().getBalance());
        assertEquals(1300, p2.getPlayerAccount().getBalance());

    }

    @Test
    public void withdraw() throws Exception {
        p1.getPlayerAccount().withdraw(100);
        p2.getPlayerAccount().withdraw(200);

        assertEquals(900, p1.getPlayerAccount().getBalance());
        assertEquals(800, p2.getPlayerAccount().getBalance());

    }

    @Test
    public void withdrawNegative() throws Exception {
        p1.getPlayerAccount().withdraw(1500);
        p2.getPlayerAccount().withdraw(1500);

        assertEquals(0, p1.getPlayerAccount().getBalance());
        assertEquals(0, p2.getPlayerAccount().getBalance());

    }


}
