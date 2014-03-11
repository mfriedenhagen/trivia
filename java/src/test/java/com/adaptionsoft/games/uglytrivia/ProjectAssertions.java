/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.adaptionsoft.games.uglytrivia;

import org.assertj.core.api.Assertions;

/**
 *
 * @author Mirko Friedenhagen
 */
public class ProjectAssertions extends Assertions {

    public static SystemOutRuleAssert assertThat(SystemOutRule actual) {
        return new SystemOutRuleAssert(actual);
    }
}
