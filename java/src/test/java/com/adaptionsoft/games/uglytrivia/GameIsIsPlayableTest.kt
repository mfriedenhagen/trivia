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

    val systemOut : SystemOutRule = SystemOutRule.create()

    override fun beforeEach() {
        systemOut.before()
    }

    override fun afterEach() {
        systemOut.after()
    }

    init {
        "A game with no players" {
            val sut = Game()
            should("should not be playable.") {
                sut.isPlayable shouldBe false
            }
        }
        "A game with one player" {
            val sut = Game()
            should("should not be playable.") {
                sut.add("Hans Wurst")
                sut.isPlayable shouldBe false
            }
        }
        "A game with more than one player" {
            val sut = Game()
            should("should be playable.") {
                sut.add("Hans Wurst 1")
                sut.add("Hans Wurst 2")
                sut.isPlayable shouldBe true
            }
        }
    }
}
