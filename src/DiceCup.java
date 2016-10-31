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

import java.util.*;
import java.lang.*;

/**
 * This class is a die cup (a cup holding multiple dice. It basically handles all the dice in the game.
 * @version 1.1.1
 */
public class DiceCup {
    private Collection<Die> dice = new ArrayList<Die>();
    private Collection<Integer> results = new ArrayList<Integer>();

    private static int dieCount;
    private static int faceCount;

    public DiceCup() {
        this.dieCount = 2;
        this.faceCount = 6;
        initDice();
    }

    public DiceCup(int dieCount) {
        if (dieCount < 2)
            throw new IndexOutOfBoundsException("There should be at least 2 dice.");
        this.dieCount  = dieCount;
        this.faceCount = 6;
        initDice();
    }

    public DiceCup(int dieCount, int faceCount) {
        if (dieCount < 2)
            throw new IndexOutOfBoundsException("There should be at least 2 dice.");
        this.dieCount  = dieCount;
        this.faceCount = faceCount;
        initDice();
    }

    public DiceCup(int dieCount, Die die) {
        if (dieCount < 2)
            throw new IndexOutOfBoundsException("There should be at least 2 dice.");
        this.dieCount = dieCount;

        initDice(die);
    }

    public DiceCup(Collection<Die> dice) {
        if (dice.size() < 2)
            throw new IndexOutOfBoundsException("There should be at least 2 dice.");
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
