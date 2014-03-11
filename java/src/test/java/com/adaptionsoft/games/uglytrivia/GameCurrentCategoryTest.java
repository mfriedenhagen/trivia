/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;
import static com.adaptionsoft.games.uglytrivia.ProjectAssertions.assertThat;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameCurrentCategoryTest extends AbstractGameTest {

    @Test
    public void checkAllPopCategories() {
        sut.add("Hans Wurst");
        sut.roll(4);
        sut.roll(4);
        assertThat(systemOut).containsSequence(
                "The category is Pop",
                "Pop Question 0",
                "Hans Wurst is the current player",
                "They have rolled a 4",
                "Hans Wurst's new location is 8",
                "The category is Pop",
                "Pop Question 1");
    }

    @Test
    public void checkAllScienceCategories() {
        sut.add("Hans Wurst");
        sut.roll(1);
        sut.roll(4);
        sut.roll(4);
        assertThat(systemOut).containsSequence(
            "The category is Science",
            "Science Question 0",
            "Hans Wurst is the current player",
            "They have rolled a 4",
            "Hans Wurst's new location is 5",
            "The category is Science",
            "Science Question 1",
            "Hans Wurst is the current player",
            "They have rolled a 4",
            "Hans Wurst's new location is 9",
            "The category is Science",
            "Science Question 2");
    }
}
