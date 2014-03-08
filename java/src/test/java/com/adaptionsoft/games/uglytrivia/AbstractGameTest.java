/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Rule;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public abstract class AbstractGameTest {

    final Game sut = new Game();

    @Rule
    public final SystemOutRule systemOutRule = SystemOutRule.create();

    void assertThatStdoutContainsInOrder(String... strings) {
        assertThat(systemOutRule.toString().split(System.lineSeparator())).containsSequence(strings);
    }

    void assertStdoutEmpty() {
        assertThat(systemOutRule.toString()).isEmpty();
    }

    void assertStdoutEquals(final StringBuilder out) {
        assertStdoutEquals(out.toString());
    }

    void assertStdoutEquals(final String expectedOutput) {
        assertThat(systemOutRule.toString()).isEqualTo(expectedOutput);
    }


}
