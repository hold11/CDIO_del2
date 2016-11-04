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
import java.util.Iterator;
import java.util.Scanner;

/**
 * This class contains the CLI methods required to print game play events to the user.
 * @version 1.1.2
 */
public class CLI {
    private Collection<Player> players;
    private int longestPlayerName;

    public CLI(Collection<Player> players) {
        this.players = players;
        if (players.size() <= 0)
            throw new NullPointerException("Players has to be defined before a CLI can be constructed.");
        System.out.println();
        System.out.println("     " + Lang.msg("Welcome") + " Black Darkness 3");
        System.out.println("=====================================");

        System.out.println(Lang.msg("EnteredSoldiers"));

        // This to place all : the same place when typing out a name to the console.
        this.longestPlayerName = 0;
        for (Player p : this.players)
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
        String spaces = "  ";
        for (int i = 0; i < longestPlayerName; i++)
            spaces += " ";
        System.out.println(getPlayerName(p) + ": " + Lang.msg("LandedOn") + " " + f);
        if (f.getScoreValue() > 0)
            System.out.println(spaces + f.getScoreValue() + " " + Lang.msg("BeenDepositedTo") + " " + p.getPlayerName() + Lang.msg("Account"));
        else if (f.getScoreValue() < 0)
            System.out.println(spaces + f.getScoreValue() * -1 + " " + Lang.msg("BeenWithdrawnFrom") + " " + p.getPlayerName() + Lang.msg("Account"));

        System.out.println(spaces + p.getPlayerName() + "'s " + Lang.msg("BalanceIs") + " " + p.getPlayerAccount().getBalance());

        if (f.checkSpecialAttribute(Field.SpecialAttr.EXTRA_TURN))
            System.out.println(p.getPlayerName() + " " + Lang.msg("GotAnotherTurn"));
    }

    public void printTossedDice(Player p, Collection<Integer> tossedDice) {
        System.out.print(getPlayerName(p) + ": " + Lang.msg("Tossed") + " ");

        for (Iterator<Integer> tossedIter = tossedDice.iterator(); tossedIter.hasNext(); ) {
            int toss = tossedIter.next();

            if(!tossedIter.hasNext())
                System.out.print(Lang.msg("And") + " " + toss + ".");
            else
                System.out.print(toss + ", ");
        }
    }

    public static String requestStr(String message) {
        String Msg;
        Scanner in = new Scanner(System.in);
        System.out.print(message + ": ");
        Msg = in.nextLine();
        return Msg;
    }
}