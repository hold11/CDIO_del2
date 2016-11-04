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

import static org.junit.Assert.*;


public class GameLogicTest {
    private GameLogic gameLogic;
    private Player p1, p2;

    @Before
    public void setUp() throws Exception {
        p1 = new Player();
        p2 = new Player();
        gameLogic = new GameLogic();

    }

    @After
    public void tearDown() throws Exception {
        Player.reset();

    }

    @Test
    public void playTurn() throws Exception {
        gameLogic.playTurn(gameLogic.getCurrentPlayer());
        DiceCup d = gameLogic.getDiceCup();
        int value = gameLogic.getTotalEyes(gameLogic.getDiceCup());

        assertTrue(gameLogic.getCurrentPlayer().getCurrentField() == Field.values()[value-2]);
    }

    @Test
    public void hasWon() throws Exception {
        p1.getPlayerAccount().setBalance(3000);

        assertTrue(gameLogic.hasWon(p1));

        p1.getPlayerAccount().setBalance(3500);

        assertTrue(gameLogic.hasWon(p1));

        p2.getPlayerAccount().setBalance(2000);

        assertFalse(gameLogic.hasWon(p2));
    }

    @Test
    public void nextPlayer() throws Exception {
        p1.setCurrentField(Field.MONASTERY);
        p2.setCurrentField(Field.THE_WEREWALL);

        assertEquals(1, gameLogic.getCurrentPlayer().getPlayerID());

        gameLogic.nextPlayer();

        assertEquals(2, gameLogic.getCurrentPlayer().getPlayerID());

        gameLogic.nextPlayer();

        assertEquals(2, gameLogic.getCurrentPlayer().getPlayerID());

        p2.setCurrentField(Field.MONASTERY);

        gameLogic.nextPlayer();

        assertEquals(1, gameLogic.getCurrentPlayer().getPlayerID());
    }

    @Test
    public void getTotalEyes() throws Exception {
        int total = 0;

        for (int i: gameLogic.getDiceCup().getResults())
            total += i;

        assertTrue(gameLogic.getTotalEyes(gameLogic.getDiceCup()) == total);
    }

}