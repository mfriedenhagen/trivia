/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;
import org.junit.Rule;
import org.junit.rules.ExternalResource;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameHowManyPlayersTest {

    private static final String ADD_TEMPLATE = "%s was added%nThey are player number %s%n";

    @Rule
    public SystemOutRule systemOutRule = new SystemOutRule();

    public static final int MAX_PLAYERS = 5;

    private final Game sut = new Game();

    @Test
    public void checkNoPlayers() {
        assertEquals(0, sut.howManyPlayers());
        assertEquals("", systemOutRule.toString());
    }

    @Test
    public void checkOnePlayer() {
        final String name = "Hans Wurst";
        final StringBuilder out = new StringBuilder(addPlayer(name, 1));
        sut.add(name);
        assertEquals(1, sut.howManyPlayers());
        assertEquals(out.toString(), systemOutRule.toString());
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
        assertEquals(out.toString(), systemOutRule.toString());
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
