/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import org.junit.Rule;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public abstract class AbstractGameTest {

    final Game sut = new Game();

    @Rule
    public final SystemOutRule systemOut = SystemOutRule.create();
}
