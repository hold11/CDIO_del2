/*
    ||======================================||
    ||    _         _     _  ___   ___      ||  Terningspil v1.0.0 | Java JDK 1.8.0_101
    ||   | |__   _ | | __| |/_  | /_  |     ||  Anders Wiberg Olsen        (s165241)
    ||   | '_ \ / \| |/ _  |  | |   | |     ||  Emil Johan Hoeg            (s152282)
    ||   | | | | O | | (_| | _| |_ _| |_    ||  Iman Chelhi                (s165228)
    ||   |_| |_|\_/|_|\__,_||_____|_____|   ||  Sebastian Tibor Bakonyvari (s145918)
    ||                                      ||  Troels Just Christoffersen (s150052)
    ||======================================||
 */

import java.util.*;
import java.lang.*;

/**
 * This class is a die cup (a cup holding multiple dice. It basically handles all the dice in the game.
 * @version 1.1.1
 */
public class DieCup {
    private Collection<Die> dice = new ArrayList<Die>();
    private Collection<Integer> results = new ArrayList<Integer>();

    private static int dieCount;
    private static int faceCount;

    public DieCup() {
        this.dieCount = 2;
        this.faceCount = 6;
        initDice();
    }

    public DieCup(int dieCount) {
        this.dieCount  = dieCount;
        this.faceCount = 6;
        initDice();
    }

    public DieCup(int dieCount, int faceCount) {
        this.dieCount  = dieCount;
        this.faceCount = faceCount;
        initDice();
    }

    public DieCup(int dieCount, Die die) {
        this.dieCount = dieCount;

        initDice(die);
    }

    public DieCup(Collection<Die> dice) {
        this.dieCount = dice.size();
        initDice(dice);
    }

    private void initDice() {
        for (int i = 0; i < dieCount; i++)
            this.dice.add(new Die(faceCount));
    }

    private void initDice(Die die) {
        for (int i = 0; i < dieCount; i++)
            this.dice.add(die);
    }

    private void initDice(Collection<Die> dice) {
        this.dice.addAll(dice);
    }

    public void addDice    (Die die)              { this.dice.add(die);        }
    public void addDice    (Collection<Die> dice) { this.dice.addAll(dice);    }

    public void removeDice (Die die)              { this.dice.remove(die);     }
    public void removeDice (Collection<Die> dice) { this.dice.removeAll(dice); }

    public void roll() {
        this.results.clear();

        for (Iterator<Die> diceIter = dice.iterator(); diceIter.hasNext(); )
            this.results.add(diceIter.next().getRolledDieResult());
    }

    public Collection<Integer> getResults() {
        return results;
    }

    public Collection<Integer> getRolledDieResults() {
        roll();
        return results;
    }
}
