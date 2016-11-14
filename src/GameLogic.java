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

import java.util.Collection;

/**
 * This class contains all rules and actual game play, this is where the magic happens.
 * @version 1.0.1
 */
public class GameLogic {
    private DiceCup diceCup;
    private int playerTurn = 1;
    private Collection<Player> players = Player.getPlayersList();
    public static final int WINNERSCORE = 3000; //score needed to win the game.

    public GameLogic(){
        diceCup = new DiceCup(); //Creates the default dicecup with 2 dice with 6 sides.
    }

    public void playTurn(Player currentPlayer) {
        if (hasWon(currentPlayer)) {
            return;
        }
        diceCup.roll();

        currentPlayer.setCurrentField(Field.values()[getTotalEyes(diceCup)-2]); // Fields enumerated [0-10], dice rolls [2-12] QED.
        if (currentPlayer.getCurrentField().getScoreValue() < 0) {              // If field score is negative, withdraw. Else deposit.
            currentPlayer.getPlayerAccount().withdraw(currentPlayer.getCurrentField().getScoreValue());
        } else {
            currentPlayer.getPlayerAccount().deposit(currentPlayer.getCurrentField().getScoreValue());
        }
    }

    public boolean hasWon(Player player) {
        if (player.getPlayerAccount().getBalance() >= WINNERSCORE)
            return true;
        else
            return false;
    }

    public void nextPlayer() {
        if (getCurrentPlayer().getCurrentField().checkSpecialAttribute(Field.SpecialAttr.EXTRA_TURN)) {
            getCurrentPlayer().setCurrentField(null);   // Setting current field to null, so extra turn does not repeat.
            return;
        }

        if (playerTurn < players.size())
            playerTurn++;
        else
            playerTurn = 1;
    }

    public int getPlayerTurn() { return playerTurn; }

    public Player getCurrentPlayer() { return Player.findPlayer(playerTurn); }

    public DiceCup getDiceCup() { return diceCup; }

    public int getTotalEyes(DiceCup diceCup) {
        int total = 0;

        for (int i: diceCup.getResults())
            total += i;
        return total;
    }
}
