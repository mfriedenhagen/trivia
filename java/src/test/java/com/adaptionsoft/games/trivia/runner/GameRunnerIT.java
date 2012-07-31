/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.trivia.runner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.mock;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;

import com.google.common.base.Charsets;
import com.google.common.collect.Collections2;
import com.google.common.io.Resources;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * Unfortuna
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(GameRunner.class)
public class GameRunnerIT {

    private static final String ENCODING = "UTF-8";

    private final PrintStream originalSystemOut = System.out;

    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    private final Random randomMock = mock(Random.class);

    @Before
    public void replaceSystemOut() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(bos, true, ENCODING));
    }

    @Before
    public void parameterizeRandomMock() {
        when(randomMock.nextInt(5)).thenReturn(5, 5, 5, 0, 2, 0, 5, 3, 0, 1, 3, 5, 0, 1, 2, 3, 1, 2, 0, 0, 5, 0, 5, 5, 2, 3, 5, 3, 3, 1, 5, 3, 1, 4, 4, 3, 5, 3, 0, 5, 4, 4, 4, 4, 0, 1, 2, 2, 3, 3);
        when(randomMock.nextInt(9)).thenReturn(6, 9, 2, 4, 7, 0, 5, 1, 0, 2, 8, 4, 2, 3, 8, 1, 2, 5, 1, 7, 8, 4, 5, 7, 8, 1, 3, 1, 9, 2, 9, 6, 2, 2, 1, 0, 2, 6, 1, 2, 8, 9, 7, 1, 3, 5, 2, 5, 1, 3);
    }

    @After
    public void restoreSystemOut() throws UnsupportedEncodingException {
        System.setOut(originalSystemOut);
    }

    /**
     * Test of main method, of class GameRunner.
     */
    //@Ignore("Until we have covered all single methods")
    @Test
    public void testMain() throws Exception {
        final String expectedStdOut = Resources.toString(Resources.getResource(this.getClass(), "result.txt"), Charsets.UTF_8);
        System.setOut(new PrintStream(bos, true, ENCODING));
        try {
            String[] args = null;
            whenNew(Random.class).withNoArguments().thenReturn(randomMock);
            GameRunner.main(args);
        } finally {
            System.setOut(originalSystemOut);
            final String capturedStdOut = new String(bos.toByteArray(), ENCODING).replaceAll("\r\n", "\n");
            assertEquals(expectedStdOut, capturedStdOut);
        }
    }
}
