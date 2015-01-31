/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import static com.adaptionsoft.games.uglytrivia.ProjectAssertions.assertThat;

import org.junit.Test;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameIsIsPlayableTest extends AbstractGameTest {

    @Test
    public void assertThatAGameWithNoPlayersIsNotPlayable() {
        assertThat(sut.isPlayable()).as("A game with no players should not be playable.").isFalse();
    }

    @Test
    public void assertThatAGameWithOnePlayerIsNotPlayable() {
        sut.add("Hans Wurst");
        assertThat(sut.isPlayable()).as("A game with one player should not be playable.").isFalse();
    }
    @Test
    public void assertThatAGameWithMoreThanOnePlayerIsPlayable() {
        sut.add("Hans Wurst 1");
        sut.add("Hans Wurst 2");
        assertThat(sut.isPlayable()).as("A game with more than one player should be playable.").isTrue();
    }
}
