/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Locale;

import org.junit.Test;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameRollTest extends AbstractGameTest {

    @Test(expected = IndexOutOfBoundsException.class)
    public void assertNoPlayersThrowsIndexOutOfBoundsException() {
        sut.roll(1);
    }

    @Test
    public void assertOnePlayerRollsTwo() {
        final String name = "Hans Wurst";
        final int roll = 2;
        sut.add(name);
        sut.roll(roll);
        assertStdoutEquals(String.format(Locale.ENGLISH,
                "%s was added%n" + //
                "They are player number 1%n" + //
                "%s is the current player%n" + //
                "They have rolled a %s%n" + //
                "%s's new location is 2%n" + //
                "The category is Sports%n" + //
                "Sports Question 0%n", name, name, roll, name));
    }

    @Test
    public void assertOnePlayerWhoHadAnsweredWronglyRollsTwo() {
        final String name = "Hans Wurst";
        final int roll = 2;
        sut.add(name);
        sut.wrongAnswer();
        sut.roll(roll);
        assertStdoutEquals(String.format(Locale.ENGLISH,
                "%s was added%n" + //
                "They are player number 1%n" + //
                "Question was incorrectly answered%n" + //
                "%s was sent to the penalty box%n" + //
                "%s is the current player%n" + //
                "They have rolled a %s%n" + //
                "%s is not getting out of the penalty box%n",
                name, name, name, roll, name));
    }

    @Test
    public void assertOnePlayerWhoHadAnsweredWronglyRollsThree() {
        final String name = "Hans Wurst";
        final int roll = 3;
        sut.add(name);
        sut.wrongAnswer();
        sut.roll(roll);
        assertStdoutEquals(String.format(Locale.ENGLISH,
                "%s was added%n" + //
                "They are player number 1%n" + //
                "Question was incorrectly answered%n" + //
                "%s was sent to the penalty box%n" + //
                "%s is the current player%n" + //
                "They have rolled a %s%n" + //
                "%s is getting out of the penalty box%n" + //
                "%s's new location is 3%n" + //
                "The category is Rock%n" + //
                "Rock Question 0%n",
                name, name, name, roll, name, name));
    }

    @Test
    public void assertOnePlayerWhoHadAnsweredWronglyRollsTwoSixesAndAThree() {
        final String name = "Hans Wurst";
        sut.add(name);
        sut.roll(6);
        sut.roll(4);
        sut.wrongAnswer();
        sut.roll(3);
        assertStdoutEquals(String.format(Locale.ENGLISH,
                "%s was added%n" + //
                "They are player number 1%n" + //
                "%s is the current player%n"+ //
                "They have rolled a 6%n" + //
                "%s's new location is 6%n" +//
                "The category is Sports%n" + //
                "Sports Question 0%n" + //
                "%s is the current player%n" + //
                "They have rolled a 4%n" + //
                "%s's new location is 10%n" + //
                "The category is Sports%n" + //
                "Sports Question 1%n" + //
                "Question was incorrectly answered%n" + //
                "%s was sent to the penalty box%n" + //
                "%s is the current player%n" + //
                "They have rolled a 3%n" + //
                "%s is getting out of the penalty box%n" + //
                "%s's new location is 1%n" + //
                "The category is Science%n" + //
                "Science Question 0%n",
                name, name, name, name, name, name, name, name, name));
        assertThat(sut.places[0]).isEqualTo(1);
    }
    @Test
    public void assertOnePlayerRollsTwoSixesAndAThree() {
        final String name = "Hans Wurst";
        sut.add(name);
        sut.roll(6);
        sut.roll(6);
        sut.roll(3);
        assertStdoutEquals(String.format(Locale.ENGLISH,
                "%s was added%n" + //
                "They are player number 1%n" + //
                "%s is the current player%n" + //
                "They have rolled a 6%n" + //
                "%s's new location is 6%n" + //
                "The category is Sports%n" + //
                "Sports Question 0%n" + //
                "%s is the current player%n" + //
                "They have rolled a 6%n" + //
                "%s's new location is 0%n" + //
                "The category is Pop%n" + //
                "Pop Question 0%n" + //
                "%s is the current player%n" + //
                "They have rolled a 3%n" + //
                "%s's new location is 3%n" + //
                "The category is Rock%n" + //
                "Rock Question 0%n",
                name, name, name, name, name, name, name));
        //6 Hans Wurst's new location is 6 The category is Sports Sports Question 0 Hans Wurst is the current player They have rolled a 6 Hans Wurst's new location is 0 The category is Pop Pop Question 0 Hans Wurst is the current player They have rolled a 3 Hans Wurst's new location is 3 The category is Rock Rock] Question 0
        assertThat(sut.places[0]).isEqualTo(3);
    }
}
