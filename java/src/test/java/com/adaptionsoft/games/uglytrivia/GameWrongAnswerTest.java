/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

/**
 *
 * @author mifr
 */
public class GameWrongAnswerTest extends AbstractGameTest {

    @Test(expected=IndexOutOfBoundsException.class)
    public void assertForZeroPlayersThrowsAnIndexOutOfBoundException() {
        sut.wrongAnswer();
    }

    @Test
    public void assertForOnePlayerCurrentPlayerIsResetImmediately() {
        sut.add("Hans Wurst 1");
        assertEquals(0, sut.currentPlayer);
        assertTrue(sut.wrongAnswer());
        assertEquals("Expected currentPlayer to be reset to 0", 0, sut.currentPlayer);
        final String capturedOut = systemOutRule.toString();
        assertThat(capturedOut, stringContainsInOrder(Arrays.asList(
                "Question was incorrectly answered", "Hans Wurst 1 was sent to the penalty box")));
    }
    @Test
    public void assertForTwoPlayersCurrentPlayerIsResetAfterTheSecondInvocation() {
        sut.add("Hans Wurst 1");
        sut.add("Hans Wurst 2");
        assertEquals(0, sut.currentPlayer);
        assertTrue(sut.wrongAnswer());
        assertEquals(1, sut.currentPlayer);
        assertTrue(sut.wrongAnswer());
        assertEquals("Expected currentPlayer to be reset to 0", 0, sut.currentPlayer);
        final String capturedOut = systemOutRule.toString();
        assertThat(capturedOut, stringContainsInOrder(Arrays.asList(
                "Question was incorrectly answered",
                "Hans Wurst 1 was sent to the penalty box",
                "Question was incorrectly answered",
                "Hans Wurst 2 was sent to the penalty box")));
    }
}
