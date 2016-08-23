/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.junit.rules.ExternalResource;

/**
 *
 * @author Mirko Friedenhagen <mfriedenhagen-at-gmail.com>
 */
public class SystemOutRule extends ExternalResource {

    private static final String ENCODING = "UTF-8";

    private static final int BUFFER_SIZE = 1024;

    private final PrintStream originalSystemOut = System.out;

    private final ByteArrayOutputStream bos = new ByteArrayOutputStream(BUFFER_SIZE);

    private SystemOutRule() {
    }

    public static SystemOutRule create() {
        return new SystemOutRule();
    }

    @Override
    protected void before() throws Throwable {
        bos.reset();
        System.setOut(new PrintStream(bos, false, ENCODING));
    }

    @Override
    protected void after() {
        System.setOut(originalSystemOut);
    }

    @Override
    public String toString() {
        try {
            final String out = new String(bos.toByteArray(), ENCODING);
            return out.replace("\r\n", "\n");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] toLines() {
        return toString().split("\n");
    }
}
