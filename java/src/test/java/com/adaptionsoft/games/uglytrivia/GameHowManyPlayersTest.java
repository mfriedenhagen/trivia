/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import java.util.Locale;

import org.junit.Test;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameHowManyPlayersTest extends AbstractGameTest {

    private static final String ADD_TEMPLATE = "%s was added%nThey are player number %s%n";

    public static final int MAX_PLAYERS = 5;

    @Test
    public void checkNoPlayers() {
        assertEquals(0, sut.howManyPlayers());
        assertStdoutEmpty();
    }

    @Test
    public void checkOnePlayer() {
        final String name = "Hans Wurst";
        final StringBuilder out = new StringBuilder(addPlayer(name, 1));
        sut.add(name);
        assertEquals(1, sut.howManyPlayers());
        assertStdoutEquals(out);
    }

    @Test
    public void checkFivePlayers() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < MAX_PLAYERS; i++) {
            final String name = "Hans Wurst " + i;
            sut.add(name);
            out.append(addPlayer(name, i + 1));
        }
        assertEquals(MAX_PLAYERS, sut.howManyPlayers());
        assertStdoutEquals(out);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void checkSixPlayers() {
        checkFivePlayers();
        sut.add("Hans Wurst " + 6);
    }

    private String addPlayer(final String name, int index) {
        return String.format(Locale.ENGLISH, ADD_TEMPLATE, name, index);
    }
}
