/**
 * Created by awo on 11/10/16.
 */
public class App {
    public static void main(String[] args) {
        Lang.setLanguage(args);

        Player p1 = new Player(TUI.requestStr(Lang.msg("chooseName")));
        Player p2 = new Player(TUI.requestStr(Lang.msg("chooseName")));

        GameLogic game = new GameLogic();
        TUI tui = new TUI(Player.getPlayersList());

        //game.playTurn(game.getCurrentPlayer());
        //tui.printLandedOnField(game.getCurrentPlayer(),game.getCurrentPlayer().getCurrentField());

        tui.printLandedOnField(p1, Field.THE_PIT);
        System.out.println();

        tui.printLandedOnField(p2, Field.WALLED_CITY);
        System.out.println();

        tui.printLandedOnField(p1, Field.THE_WEREWALL);
        System.out.println();
    }
}
