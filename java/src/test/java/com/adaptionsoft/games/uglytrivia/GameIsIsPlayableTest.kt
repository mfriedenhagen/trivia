/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.uglytrivia

/**
 * @author Mirko Friedenhagen
 */
class GameIsIsPlayableTest : SystemOutShouldSpec() {

    init {
        "A game" {
            should("not be playable with no players.") {
                val sut = Game()
                sut.isPlayable shouldBe false
                systemOut.toLines().size shouldBe 1
            }
            should("not be playable with one player.") {
                val sut = Game()
                sut.add("Hans Wurst")
                sut.isPlayable shouldBe false
                systemOut.toLines().size shouldBe 2
            }
            should("be playable with more than one player.") {
                val sut = Game()
                sut.add("Hans Wurst 1")
                sut.add("Hans Wurst 2")
                sut.isPlayable shouldBe true
                systemOut.toLines().size shouldBe 4
            }
        }

    }
}
