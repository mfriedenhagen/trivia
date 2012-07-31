/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameCreateRockQuestionTest extends AbstractGameTest {

    @Test
    public void checkAnswerForRockQuestionForZero() {
        assertEquals("Rock Question 0", sut.createRockQuestion(0));
    }
    @Test
    public void checkAnswerRockQuestionForSix() {
        assertEquals("Rock Question 6", sut.createRockQuestion(6));
    }
}
