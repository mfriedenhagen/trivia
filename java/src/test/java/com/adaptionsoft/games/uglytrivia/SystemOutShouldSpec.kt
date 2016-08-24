package com.adaptionsoft.games.uglytrivia

import io.kotlintest.specs.ShouldSpec

abstract class SystemOutShouldSpec : ShouldSpec() {

    val systemOut = SystemOutRule.create()

    override fun beforeEach() {
        systemOut.before()
    }

    override fun afterEach() {
        systemOut.after()
    }
}