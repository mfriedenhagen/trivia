/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirko Friedenhagen <mirko.friedenhagen@1und1.de>
 */
public class GameTest {

    public GameTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of createRockQuestion method, of class Game.
     */
    @Test
    public void testCreateRockQuestion() {
        System.out.println("createRockQuestion");
        int index = 0;
        Game instance = new Game();
        String expResult = "";
        String result = instance.createRockQuestion(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPlayable method, of class Game.
     */
    @Test
    public void testIsPlayable() {
        System.out.println("isPlayable");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.isPlayable();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class Game.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String playerName = "";
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.add(playerName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of howManyPlayers method, of class Game.
     */
    @Test
    public void testHowManyPlayers() {
        System.out.println("howManyPlayers");
        Game instance = new Game();
        int expResult = 0;
        int result = instance.howManyPlayers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of roll method, of class Game.
     */
    @Test
    public void testRoll() {
        System.out.println("roll");
        int roll = 0;
        Game instance = new Game();
        instance.roll(roll);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wasCorrectlyAnswered method, of class Game.
     */
    @Test
    public void testWasCorrectlyAnswered() {
        System.out.println("wasCorrectlyAnswered");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.wasCorrectlyAnswered();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of wrongAnswer method, of class Game.
     */
    @Test
    public void testWrongAnswer() {
        System.out.println("wrongAnswer");
        Game instance = new Game();
        boolean expResult = false;
        boolean result = instance.wrongAnswer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
