/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Black Darkness 3 - CDIO_del2
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v1.0.0
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høg (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class PlayerTest {
    private Player p1, p2;
    /**
     * Sets up 2 players, with the default name.
     * @throws Exception
     */

    @Before
    public void setUp() throws Exception {
        p1 = new Player();
        p2 = new Player();

    }

    /**
     * Resets all the users so we won't end up with 60 users.
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        Player.reset();

    }

    /**
     * Tests if player account can be fetched from player.
     * @throws Exception
     */
    @Test
    public void getPlayerAccount() throws Exception {
        p1.getPlayerAccount().setBalance(150);
        p2.getPlayerAccount().setBalance(200);

        assertEquals(150, p1.getPlayerAccount().getBalance());
        assertEquals(200, p2.getPlayerAccount().getBalance());

    }

    /**
     * Tests if the player ID can be fetched from a player, and the player ID matched correctly to the player.
     * @throws Exception
     */
    @Test
    public void getPlayerID() throws Exception {
        assertEquals(1, p1.getPlayerID());
        assertEquals(2, p2.getPlayerID());

    }

    /**
     * Tests if the Player 1 and Player 2 gets the correct name.
     * @throws Exception
     */
    @Test
    public void getPlayerName() throws Exception {
        assertEquals("Player 1", p1.getPlayerName());
        assertEquals("Player 2", p2.getPlayerName());

    }

    /**
     * Tests if a player can be found by ID.
     * @throws Exception
     */
    @Test
    public void findPlayer() throws Exception {
        assertEquals("Player 1", Player.findPlayer(1).getPlayerName());
        assertEquals("Player 2", Player.findPlayer(2).getPlayerName());

    }

    /**
     * Tests if the player list can be fetched.
     * @throws Exception
     */
    @Test
    public void getPlayersList() throws Exception {
        List<Player> players = Player.getPlayersList();
        assertEquals(2, players.size());

    }

}