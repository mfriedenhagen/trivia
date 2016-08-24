/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia

import io.kotlintest.specs.ShouldSpec

/**

 * @author Mirko Friedenhagen
 */
class GameIsIsPlayableTest : ShouldSpec() {

    val systemOut = SystemOutRule.create()

    override fun beforeEach() {
        systemOut.before()
    }

    override fun afterEach() {
        systemOut.after()
    }

    init {
        "A game" {
            should("not be playable with no players.") {
                val sut = Game()
                sut.isPlayable shouldBe false
            }
            should("not be playable with one player.") {
                val sut = Game()
                sut.add("Hans Wurst")
                sut.isPlayable shouldBe false
            }
            should("be playable with more than one player.") {
                val sut = Game()
                sut.add("Hans Wurst 1")
                sut.add("Hans Wurst 2")
                sut.isPlayable shouldBe true
            }
        }
    }
}
