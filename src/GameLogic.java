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
    private int currentPlayer;
    private final int WINNERSCORE = 3000; //score needed for winning game.

    public GameLogic(){
        diceCup = new DiceCup(); //Creates 2 dice with 6 sides.
    }

    public void playTurn(Player currentPlayer){

        if (hasWon(currentPlayer))
        {
            // call method
            return;
        }


    }

    public void nextPlayer(){

    }

    public boolean hasWon(Player player) {
        if (player.getPlayerScore() >= WINNERSCORE)
            return true;
        else
            return false;
    }
}
