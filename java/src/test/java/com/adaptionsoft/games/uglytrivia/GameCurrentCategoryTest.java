/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import org.junit.Test;

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
        assertThatStdoutContainsInOrder(
                "The category is Pop",
                "Pop Question 0",
                "The category is Pop",
                "Pop Question 1");
    }

    @Test
    public void checkAllScienceCategories() {
        sut.add("Hans Wurst");
        sut.roll(1);
        sut.roll(4);
        sut.roll(4);
        assertThatStdoutContainsInOrder(
                "The category is Science",
                "Science Question 0",
                "The category is Science",
                "Science Question 1",
                "The category is Science",
                "Science Question 2");
    }
}
