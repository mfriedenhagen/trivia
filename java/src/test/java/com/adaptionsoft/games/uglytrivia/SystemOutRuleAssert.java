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
public class SystemOutRuleAssert extends AbstractAssert<SystemOutRuleAssert, SystemOutRule>{

    SystemOutRuleAssert(SystemOutRule actual) {
        super(actual, SystemOutRuleAssert.class);
    }

    public SystemOutRuleAssert isEmpty() {
        isNotNull();
        if (!actual.toString().isEmpty()) {
            failWithMessage("Expected System.out to be empty");
        }
        return this;
    }

    public SystemOutRuleAssert isEqualTo(String out) {
        isNotNull();
        final String stdoutToString = actual.toString();
        if (!stdoutToString.equals(out)) {
            failWithMessage("Expected System.out to be %s but was %s", out, stdoutToString);
        }
        return this;
    }

    public SystemOutRuleAssert isEqualTo(StringBuilder out) {
        isNotNull();
        return isEqualTo(out.toString());
    }

    public SystemOutRuleAssert isEqualTo(final String format, Object... params) {
        isNotNull();
        return isEqualTo(String.format(Locale.ENGLISH, format, params));
    }

    public SystemOutRuleAssert containsSequence(String... strings) {
        isNotNull();
        Assertions.assertThat(actual.toLines()).containsSequence(strings);
        return this;
    }
}
