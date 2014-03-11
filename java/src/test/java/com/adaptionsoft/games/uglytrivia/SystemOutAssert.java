/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adaptionsoft.games.uglytrivia;

import java.util.Locale;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;

/**
 *
 * @author Mirko Friedenhagen
 */
public class SystemOutAssert extends AbstractAssert<SystemOutAssert, SystemOutRule>{

    SystemOutAssert(SystemOutRule actual) {
        super(actual, SystemOutAssert.class);
    }

    public SystemOutAssert isEmpty() {
        isNotNull();
        if (!actual.toString().isEmpty()) {
            failWithMessage("Expected System.out to be empty");
        }
        return this;
    }

    public SystemOutAssert isEqualTo(String out) {
        isNotNull();
        final String stdoutToString = actual.toString();
        if (!stdoutToString.equals(out)) {
            failWithMessage("Expected System.out to be %s but was %s", out, stdoutToString);
        }
        return this;
    }

    public SystemOutAssert isEqualTo(StringBuilder out) {
        isNotNull();
        return isEqualTo(out.toString());
    }

    public SystemOutAssert isEqualTo(final String format, Object... params) {
        isNotNull();
        return isEqualTo(String.format(Locale.ENGLISH, format, params));
    }

    public SystemOutAssert containsSequence(String... strings) {
        isNotNull();
        Assertions.assertThat(actual.toLines()).containsSequence(strings);
        return this;
    }
}
