/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameIsIsPlayableTest extends AbstractGameTest {

    @Test
    public void assertThatAGameWithNoPlayersIsNotPlayable() {
        assertFalse("A game with no players should not be playable.", sut.isPlayable());
    }

    @Test
    public void assertThatAGameWithOnePlayerIsNotPlayable() {
        sut.add("Hans Wurst");
        assertFalse("A game with one player should not be playable.", sut.isPlayable());
    }
    @Test
    public void assertThatAGameWithMoreThanOnePlayerIsPlayable() {
        sut.add("Hans Wurst 1");
        sut.add("Hans Wurst 2");
        assertTrue("A game with more than one player should be playable.", sut.isPlayable());
    }
}
