/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.adaptionsoft.games.trivia.runner

import com.adaptionsoft.games.uglytrivia.SystemOutShouldSpec
import io.kotlintest.mock.`when`
import io.kotlintest.mock.mock
import java.util.*

/**
 * Unfortuna

 * @author Mirko Friedenhagen
 */
class GameRunnerIT : SystemOutShouldSpec() {

    val randomMock : Random = mock()

    override fun beforeEach() {
        super.beforeEach()
        // React when dice shows  5 because com.adaptionsoft.games.trivia.runner.GameRunner.main()
        // uses "random.nextInt(5) + 1". So substract 1 from the reference values for 1-6!
        `when`(randomMock.nextInt(5)).thenReturn(5, 5, 5, 0, 2, 0, 5, 3, 0, 1, 3, 5, 0, 1, 2, 3, 1, 2, 0, 0, 5, 0, 5, 5, 2, 3, 5, 3, 3, 1, 5, 3, 1, 4, 4, 3, 5, 3, 0, 5, 4, 4, 4, 4, 0, 1, 2, 2, 3, 3)
        `when`(randomMock.nextInt(9)).thenReturn(6, 9, 2, 4, 7, 0, 5, 1, 0, 2, 8, 4, 2, 3, 8, 1, 2, 5, 1, 7, 8, 4, 5, 7, 8, 1, 3, 1, 9, 2, 9, 6, 2, 2, 1, 0, 2, 6, 1, 2, 8, 9, 7, 1, 3, 5, 2, 5, 1, 3)
    }

    init {
        "A Game" {
            should("produce the correct output") {
                val expectedOutput = javaClass.getResourceAsStream("result.txt").bufferedReader().readText()
                GameRunner(randomMock).main()
                expectedOutput shouldEqual systemOut.toString()
            }
        }

    }
}
