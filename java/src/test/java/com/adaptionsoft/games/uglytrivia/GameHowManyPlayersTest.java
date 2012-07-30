/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirko Friedenhagen <mirko.friedenhagen@1und1.de>
 */
public class GameHowManyPlayersTest {

    public static final int MAX_PLAYERS = 5;

    private final Game sut = new Game();

    @Test
    public void checkNoPlayers() {
        assertEquals(0, sut.howManyPlayers());
    }

    @Test
    public void checkOnePlayer() {
        sut.add("Hans Wurst");
        assertEquals(1, sut.howManyPlayers());
    }

    @Test
    public void checkFivePlayers() {
        for (int i = 0; i < MAX_PLAYERS; i++) {
            sut.add("Hans Wurst");
        }
        assertEquals(MAX_PLAYERS, sut.howManyPlayers());
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkSixPlayers() {
        for (int i = 0; i < 6; i++) {
            sut.add("Hans Wurst");
        }
    }
}
