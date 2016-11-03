import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.lang.*;

import static org.junit.Assert.*;

/*
           ,                                             |
          /#\         _         _     _    ___   ___     | Projekt: Black Darkness 3 - CDIO_del2
         /###\       | |__   _ | | __| |  /_  | /_  |    | Version: v1.0.0
        /#####\      | '_ \ / \| |/ _  |    | |   | |    |
       /##,-,##\     | | | | O | | (_| |   _| |_ _| |_   | Anders Wiberg Olsen (s165241), Emil Johan Høj (s152282),
      /##(   )##\    |_| |_|\_/|_|\__,_|  |_____|_____|  | Iman Chelhi (s165228), Troels Just Christoffersen (s120052)
     /#.--   --.#\                                       | Sebastian Tibor Bakonyvári (s145918), Valentin Leon Christensen (s152735)
    /`           ´\                                      |
 */

public class DieTest {
    private Die die;
    private int faces = 0;

    @Before
    public void setUp() throws Exception {
        if (faces == 0)
            die = new Die();
        else
            die = new Die(faces);
    }

    @Test
    public void getRolledDieResult() throws Exception {
//         Default amount of faces
//
//        List<Integer> diceFaces = new ArrayList<Integer>();
//
//        for (int i = 0; i < 60000; i++)
//            diceFaces.add(die.getRolledDieResult());
//
//        for (Iterator<Integer> faceIter = diceFaces.iterator(); faceIter.hasNext(); ) {
//            assertEquals(10000, faceIter.next(), 400);
//        }
//        for (int i = 0; i < diceFaces.size(); i++)
//            assertEquals(10000, diceFaces.get(i), 400);
    }

    @Test
    public void getDieResult() throws Exception {

    }

    @Test
    public void roll() throws Exception {

    }

    @Test
    public void setFaceCount() throws Exception {

    }

    @Test
    public void getFaceCount() throws Exception {

    }

}