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
public class GameCreateRockQuestionTest extends AbstractGameTest {

    @Test
    public void checkAnswerForRockQuestionForZero() {
        assertThat(sut.createRockQuestion(0)).isEqualTo("Rock Question 0");
    }
    @Test
    public void checkAnswerRockQuestionForSix() {
        assertThat(sut.createRockQuestion(6)).isEqualTo("Rock Question 6");
    }
}
