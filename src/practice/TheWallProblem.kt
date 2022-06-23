package practice

import kotlin.random.Random

/*
    problem:
    Given a wall, which is made up of two types of bricks (Porous / opaque). Porous bricks allow
    water pass through them. Opaque won't. Find whether water reaches to ground, if there is any
    rainfall. (given any brick combination). Water can flow from top to bottom, diagonally,
    horizontally as well. Only flowing from bottom to top is not possible.

    solution:
    assume an NxN matrix where 1 allow water and 0 not
    for each node in the first row
    if node row is the row and node allow water return true
    else->
        travers adjacent if adjacent allow water

 */



fun main() {
    val randomN = Random.nextInt(3, 10)
    val input = Array(randomN) {
        Array(randomN) {
            Random.nextInt(0, 2) != 0
        }
    }

    val visitedNodes = Array(randomN) {
        Array(randomN) {
            false
        }
    }
    input.forEach {
        println(it.contentDeepToString())
    }

    for (x in 0 until randomN) {
        if(input[0][x]) {
            travers(input, 0, x, visitedNodes)
        }
    }


}

fun travers(input: Array<Array<Boolean>>, i: Int, j: Int, visitedNodes: Array<Array<Boolean>>) {

    visitedNodes[i][j] = true
    if (i == input.size - 1) {
        println("We Reach Ground: from column:$j")
        return
    }
    var row = i
    while (row <= i + 1 ) {
        var column = j - 1
        while (column <= column + 1 ) {
            if ( row >= 0&&row<input.size&& column >= 0&&column<input.size&&input[row][column] && visitedNodes[row][column].not()) {
                travers(input, row, column, visitedNodes)
            }

            column++
        }
        row++
    }
    visitedNodes[i][j] = false
}
