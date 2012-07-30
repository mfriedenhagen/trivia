/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameCreateRockQuestionTest {

    private final Game sut = new Game();

    public GameCreateRockQuestionTest() {
    }

    @Test
    public void checkRockQuestionForZero() {
        assertEquals("Rock Question 0", sut.createRockQuestion(0));
    }
    @Test
    public void checkRockQuestionForSix() {
        assertEquals("Rock Question 6", sut.createRockQuestion(6));
    }
}
