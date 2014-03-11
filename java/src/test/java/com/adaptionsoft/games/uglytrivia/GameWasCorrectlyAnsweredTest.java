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
public class GameWasCorrectlyAnsweredTest extends AbstractGameTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void assertNoPlayersThrowsIndexOutOfBounds() {
        sut.wasCorrectlyAnswered();
    }

    @Test
    public void assertOnePlayerNotInPenaltyBox() {
        final String name = "Hans Wurst 1";
        sut.add(name);
        assertThat(sut.wasCorrectlyAnswered()).isTrue();
        assertThat(systemOutRule).isEqualTo(
                "%s was added%n" + //
                "They are player number 1%n" + //
                "Answer was corrent!!!!%n" +//
                "%s now has 1 Gold Coins.%n", name, name);
        assertThat(sut.purses[0]).isEqualTo(1);
    }

    @Test
    public void assertTwoPlayersNotInPenaltyBox() {
        final String name = "Hans Wurst 1";
        final String name2 = "Hans Wurst 2";
        sut.add(name);
        sut.add(name2);
        assertThat(sut.wasCorrectlyAnswered()).isTrue();
        assertThat(systemOutRule).isEqualTo(
                "%s was added%n" + //
                "They are player number 1%n" + //
                "%s was added%n" + //
                "They are player number 2%n" + //
                "Answer was corrent!!!!%n" +//
                "%s now has 1 Gold Coins.%n", name, name2, name);
        assertThat(sut.purses[0]).isEqualTo(1);
    }

    @Test
    public void assertOnePlayerInPenaltyBoxGettingOut() {
        final String name = "Hans Wurst 1";
        sut.add(name);
        sut.wrongAnswer();
        sut.roll(3);
        assertThat(sut.wasCorrectlyAnswered()).isTrue();
        assertThat(systemOutRule).isEqualTo(
                "%s was added%n" + //
                "They are player number 1%n" + //
                "Question was incorrectly answered%n" + //
                "%s was sent to the penalty box%n" + //
                "%s is the current player%n" + //
                "They have rolled a 3%n" + //
                "%s is getting out of the penalty box%n" +//
                "%s's new location is 3%n" + //
                "The category is Rock%n" + //
                "Rock Question 0%n" + //
                "Answer was correct!!!!%n" + //
                "%s now has 1 Gold Coins.%n",
                name, name, name, name, name, name);
        assertThat(sut.purses[0]).isEqualTo(1);
    }

    @Test
    public void assertOnePlayerInPenaltyBoxNotGettingOut() {
        final String name = "Hans Wurst 1";
        sut.add(name);
        sut.wrongAnswer();
        assertThat(sut.wasCorrectlyAnswered()).isTrue();
        assertThat(systemOutRule).isEqualTo(
                "%s was added%n" + //
                "They are player number 1%n" + //
                "Question was incorrectly answered%n" + //
                "%s was sent to the penalty box%n",
                name, name);
        assertThat(sut.purses[0]).isEqualTo(0);
    }
}
