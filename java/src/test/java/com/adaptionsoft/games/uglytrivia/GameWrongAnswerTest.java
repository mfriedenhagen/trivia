/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import static com.adaptionsoft.games.uglytrivia.ProjectAssertions.assertThat;


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
        assertThat(sut.currentPlayer).isEqualTo(0);
        assertThat(sut.wrongAnswer()).isTrue();
        final int expectedPlayer = 0;
        assertThat(sut.currentPlayer).as("Expected currentPlayer to be reset to %d", expectedPlayer).isEqualTo(expectedPlayer);
        assertThat(systemOutRule).containsSequence(
                "Question was incorrectly answered",
                "Hans Wurst 1 was sent to the penalty box");
    }
    @Test
    public void assertForTwoPlayersCurrentPlayerIsResetAfterTheSecondInvocation() {
        sut.add("Hans Wurst 1");
        sut.add("Hans Wurst 2");
        assertThat(sut.currentPlayer).isEqualTo(0);
        assertThat(sut.wrongAnswer()).isTrue();
        assertThat(sut.currentPlayer).isEqualTo(1);
        assertThat(sut.wrongAnswer()).isTrue();
        final int expectedPlayer = 0;
        assertThat(sut.currentPlayer). as("Expected currentPlayer to be reset to %d", expectedPlayer).isEqualTo(expectedPlayer);
        assertThat(systemOutRule).containsSequence(
                "Question was incorrectly answered",
                "Hans Wurst 1 was sent to the penalty box",
                "Question was incorrectly answered",
                "Hans Wurst 2 was sent to the penalty box");
    }
}
