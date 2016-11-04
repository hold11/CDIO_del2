import java.util.Collection;

/**
 * Created by tjc on 1/11/16.
 */
/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Black Darkness 3 - CDIO_del2
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v1.0.0
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | ( | |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høj (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

public class GameLogic {
    private DiceCup diceCup;
    private int playerTurn = 1;
    private Collection<Player> players = Player.getPlayersList();
    private final int WINNERSCORE = 3000; //score needed to win the game.

    public GameLogic(){
        diceCup = new DiceCup(); //Creates the default dicecup with 2 dice with 6 sides.
    }

    public void playTurn(Player currentPlayer) {
        if (hasWon(currentPlayer)) {
            //TODO: call method
            return;
        }

        diceCup.roll();

        //TODO: NullPointer Exception because the player doesn't necessarily stand on any field yet.
        if (currentPlayer.getCurrentField().checkSpecialAttribute(Field.SpecialAttr.EXTRA_TURN))
            nextPlayer(true);
        else
            nextPlayer(false);
    }

    public boolean hasWon(Player player) {
        if (player.getPlayerAccount().getBalance() >= WINNERSCORE)
            return true;
        else
            return false;
    }

    public void nextPlayer(boolean repeatedTurn) {
        if (repeatedTurn)
            return;

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
