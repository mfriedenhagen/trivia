/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import java.util.Arrays;
import static org.hamcrest.Matchers.isEmptyString;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import org.junit.Rule;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public abstract class AbstractGameTest {

    final Game sut = new Game();

    @Rule
    public final SystemOutRule systemOutRule = new SystemOutRule();

    void assertThatStdoutContainsInOrder(String... strings) {
        assertThat(systemOutRule.toString(), stringContainsInOrder(Arrays.asList(strings)));
    }

    void assertStdoutEmpty() {
        assertThat(systemOutRule.toString(), isEmptyString());
    }

    void assertStdoutEquals(final StringBuilder out) {
        assertStdoutEquals(out.toString());
    }

    void assertStdoutEquals(final String expectedOutput) {
        assertEquals(expectedOutput, systemOutRule.toString());
    }


}
