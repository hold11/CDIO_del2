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

/**
 * This Class contains the Main method and handles all calls between the CLI and the Gamelogic.
 * @version 1.0.0
 */
public class App {
    public static void main(String[] args) {
        Lang.setLanguage(args);

        Player p1 = new Player(CLI.requestStr(Lang.msg("chooseName")));
        Player p2 = new Player(CLI.requestStr(Lang.msg("chooseName")));

        GameLogic game = new GameLogic();
        CLI cli = new CLI(Player.getPlayersList());

        game.playTurn(game.getCurrentPlayer());
        cli.printLandedOnField(game.getCurrentPlayer(), game.getCurrentPlayer().getCurrentField());
        System.out.println();

        game.playTurn(game.getCurrentPlayer());
        cli.printLandedOnField(game.getCurrentPlayer(), game.getCurrentPlayer().getCurrentField());
        System.out.println();
    }
}