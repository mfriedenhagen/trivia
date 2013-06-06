/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.trivia.runner;

import com.adaptionsoft.games.uglytrivia.SystemOutRule;
import static org.junit.Assert.assertEquals;

import java.util.Random;

import com.google.common.base.Charsets;
import com.google.common.io.Resources;
import java.io.IOException;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unfortuna
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class GameRunnerIT {

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    private final Random randomMock = mock(Random.class);

    @Before
    public void parameterizeRandomMock() {
        when(randomMock.nextInt(5)).thenReturn(5, 5, 5, 0, 2, 0, 5, 3, 0, 1, 3, 5, 0, 1, 2, 3, 1, 2, 0, 0, 5, 0, 5, 5, 2, 3, 5, 3, 3, 1, 5, 3, 1, 4, 4, 3, 5, 3, 0, 5, 4, 4, 4, 4, 0, 1, 2, 2, 3, 3);
        when(randomMock.nextInt(9)).thenReturn(6, 9, 2, 4, 7, 0, 5, 1, 0, 2, 8, 4, 2, 3, 8, 1, 2, 5, 1, 7, 8, 4, 5, 7, 8, 1, 3, 1, 9, 2, 9, 6, 2, 2, 1, 0, 2, 6, 1, 2, 8, 9, 7, 1, 3, 5, 2, 5, 1, 3);
    }

    /**
     * Test of main method, of class GameRunner.
     */
    @Test
    public void testMain() throws IOException {
        final String expectedStdOut = Resources.toString(Resources.getResource(this.getClass(), "result.txt"), Charsets.UTF_8);
        new GameRunner(randomMock).main();
        final String capturedStdOut = String.valueOf(systemOutRule).replaceAll("\r\n", "\n");
        assertEquals(expectedStdOut, capturedStdOut);
    }
}
