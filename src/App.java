import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by awo on 11/10/16.
 */
public class App {

    private static String lang;
    private static String country;
    private static Locale locale;

    public static ResourceBundle msg;

    public static void main(String[] args) {
        setLanguage(args);

        Player p1 = new Player(TUI.requestStr(msg.getString("chooseName")));
        Player p2 = new Player(TUI.requestStr(msg.getString("chooseName")));

        GameLogic game = new GameLogic();
        TUI tui = new TUI(Player.getPlayersList());

        game.playTurn(game.getCurrentPlayer());
        tui.printLandedOnField(game.getCurrentPlayer(),game.getCurrentPlayer().getCurrentField());

        tui.printLandedOnField(p1, Field.THE_PIT);
        System.out.println();

        tui.printLandedOnField(p2, Field.WALLED_CITY);
        System.out.println();

        tui.printLandedOnField(p1, Field.THE_WEREWALL);
        System.out.println();
    }

    private static void setLanguage(String[] args) {
        if (args.length != 2) {
            lang    = "en";
            country = "US";
        } else {
            lang    = args[0];
            country = args[1];
        }

        locale = new Locale(lang, country);
        msg = ResourceBundle.getBundle("lang", locale);
    }
}
