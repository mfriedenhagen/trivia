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
import com.google.common.io.Resources;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(GameRunner.class)
public class GameRunnerTest {

    private static final String ENCODING = "UTF-8";

    private final PrintStream originalSystemOut = System.out;

    private final ByteArrayOutputStream bos = new ByteArrayOutputStream();

    private final Random randomMock = mock(Random.class);

    @Before
    public void replaceSystemOut() throws UnsupportedEncodingException {
        System.setOut(new PrintStream(bos, true, ENCODING));
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
        final String expectedStdOut = Resources.toString(Resources.getResource(this.getClass(), "GameRunnerTest1.txt"), Charsets.UTF_8);
        System.setOut(new PrintStream(bos, true, ENCODING));
        try {
            String[] args = null;
            whenNew(Random.class).withNoArguments().thenReturn(randomMock);
            when(randomMock.nextInt(5)).thenReturn(4);
            GameRunner.main(args);
        } finally {
            System.setOut(originalSystemOut);
            final String capturedStdOut = new String(bos.toByteArray(), ENCODING);
            assertEquals(expectedStdOut, capturedStdOut);
        }
    }
}
