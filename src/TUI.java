import java.util.Collection;
import java.util.Scanner;

/**
 * Created by awo on 02/11/16.
 */
public class TUI {
    private Collection<Player> players;
    private int longestPlayerName;

    public TUI(Collection<Player> players) {
        this.players = players;
        if (players.size() <= 0)
            throw new NullPointerException(Lang.msg("ERR_PlayersDefined"));
        System.out.println();
        System.out.println("     " + Lang.msg("Welcome") + " Black Darkness 3");
        System.out.println("=====================================");

        System.out.println(Lang.msg("EnteredSoldiers"));

        // This to place all : the same place when typing out a name to the console.
        this.longestPlayerName = 0;
        for (Player p : players)
        {
            System.out.println(" * " + p.getPlayerName());
            if (p.getPlayerName().length() > this.longestPlayerName)
                longestPlayerName = p.getPlayerName().length();
        }
        System.out.println("\n=====================================");
    }

    private int getPlayerNameSpaces(Player p) { return longestPlayerName - p.getPlayerName().length(); }

    public String getPlayerName(Player p) {
        String outName;
        outName = p.getPlayerName();
        for (int i = 0; i < getPlayerNameSpaces(p); i++)
            outName += " ";
        return outName;
    }

    public void printPlayerName(Player p) {
        System.out.print(p.getPlayerName());
        for (int i = 0; i < getPlayerNameSpaces(p); i++)
            System.out.print(" ");
        System.out.print(": ");
    }

    public void printLandedOnField(Player p, Field f) {
        System.out.println(getPlayerName(p) + ": " + Lang.msg("LandedOn") + " " + f);
        if (f.getScoreValue() > 0)
            System.out.println(f.getScoreValue() + " " + Lang.msg("BeenDespositedTo") + " " + p.getPlayerName() + Lang.msg("Account"));
        else if (f.getScoreValue() < 0)
            System.out.println(f.getScoreValue() * -1 + " " + Lang.msg("BeenWithdrawnFrom") + " " + p.getPlayerName() + Lang.msg("Account"));

        if (f.checkSpecialAttribute(Field.SpecialAttribute.EXTRA_TURN))
            System.out.println(p.getPlayerName() + " " +Lang.msg("GotAnotherTurn"));
    }

    public static String requestStr(String message) {
        System.out.print(message + ": ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }
}
