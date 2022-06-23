package practice

import java.util.*
import kotlin.collections.ArrayList

/*
    my solution is
    - convert the chars input ot 2d array
    - convert to 2d array to adjacent list base on moves from every vertex
    - take every work take every character of the word find its index search for this index adjacent list with visited nodes as parameter
 */

fun main(args: Array<String>) {
    val input = arrayOf("aaey,rrum,tgmn,ball", "true,all,ball,mur,raeymnl,tall,trum")
    matrixChallenge(input)
}

fun matrixChallenge(input: Array<String>) {
    val inputAs2dArray: Array<Array<Char>> = Array(4) {
        Array(4) { '\u0000' }
    }

    var index = 0
    input[0].split(",").forEach {
        inputAs2dArray[index] = it.toCharArray().toTypedArray()
        index++
    }
    inputAs2dArray.forEach {
        println(it.contentDeepToString())
    }
    val graph = convertInputToAdjacencyList(inputAs2dArray)
    println(graph.toString())
    graph.reset()
    input[1].split(",").forEach OUTER@ { word ->
        val firstCharIndices = findIndices(graph.nodeLabels.toList(), word[0])
        firstCharIndices.forEach FIRSTCHARLOOP@{ firstCharIndex ->
            var nextCharIndexes = listOf(firstCharIndex)
            var result = true
            word.subSequence(1, word.length).forEach { char ->
                nextCharIndexes.forEach INNER@ {
                    val charIndexes = graph.searchForCharInNotVisitedAdjacent(char, it)
                    if (charIndexes.isEmpty()) {
                        result = false
                        graph.reset()
                        return@INNER
                    } else {
                        nextCharIndexes = charIndexes
                        result = true
                    }
                }
            }
            if (result) {
                println("created word: $word started from index:$firstCharIndex")
                graph.reset()
                return@OUTER
            }
        }

    }


}

private fun findIndices(
    chars: List<Char>,
    it: Char
): List<Int> {
    val indices = ArrayList<Int>()
    chars.forEachIndexed { index, c ->
        if (c == it) {
            indices.add(index)
        }
    }
    return indices
}

fun convertInputToAdjacencyList(input: Array<Array<Char>>): ThisGraph {
    val adjacentMoves = ArrayList<Move>(8)
    adjacentMoves.add(Move(0, -1))
    adjacentMoves.add(Move(0, 1))
    adjacentMoves.add(Move(-1, 0))
    adjacentMoves.add(Move(1, 0))
    adjacentMoves.add(Move(-1, -1))
    adjacentMoves.add(Move(1, -1))
    adjacentMoves.add(Move(1, 1))
    adjacentMoves.add(Move(-1, 1))
    val charsList = ArrayList<Char>()
    val graph = ThisGraph()

    var vertexIndex = 0
    val vertexMatchesIndex = Array(16) {
        '\u0000'
    }
    for (rowIndex in input.indices) {
        for (columnIndex in input[rowIndex].indices) {
            val currentChar = input[rowIndex][columnIndex]
            vertexMatchesIndex[vertexIndex] = currentChar
            //fill adjacency
            adjacentMoves.forEach { move ->
                try {
                    val char = input[rowIndex + move.x][columnIndex + move.y]
                    val adjacentX = rowIndex + move.x
                    val adjacentY = columnIndex + move.y
                    val adjacentIndex = (4 * adjacentX) + adjacentY
                    graph.addEdge(vertexIndex, adjacentIndex)
                } catch (exception: Exception) {

                }
            }
            charsList.add(currentChar)
            vertexIndex++

        }
    }
    graph.nodeLabels = vertexMatchesIndex
    return graph
}

class ThisGraph {
    private val adjacencyList = Array<LinkedList<Int>>(16) {
        LinkedList()
    }
    private val visited = Array(16) {
        false
    }

    lateinit var nodeLabels: Array<Char>
    fun setNodeLabel(nodeLabels: Array<Char>) {
        this.nodeLabels = nodeLabels
    }


    fun addEdge(vertex: Int, adjacent: Int) {
        adjacencyList[vertex].add(adjacent)
    }

    fun depthFirstSearch(node: Int, chars: String) {
        visited[node] = true
        val char = nodeLabels[node]
        adjacencyList[node].forEach {
            if (visited[it].not()) {
                println(chars)
                println(chars.reversed())

                depthFirstSearch(it, chars + char)
            }
        }

    }

    fun canWeCreateThisWord(word: String, startVertex: Int) {
        val indices = findIndices(nodeLabels.toList(), word[0])
        visited[startVertex] = true
        if (indices.isEmpty()) {
            println("cant find this char ${word[0]}")
            return
        } else {
            indices.forEach {
                if (visited[it].not()) {
                    if (word.length > 1) {
                        canWeCreateThisWord(word.subSequence(1, word.length).toString(), it)
                    } else {
                        println("done")
                    }
                }
            }

        }
    }

    fun searchForCharInNotVisitedAdjacent(char: Char, vertexIndex: Int): List<Int> {
        val result = ArrayList<Int>()
        visited[vertexIndex] = true
        val adjacent = adjacencyList[vertexIndex]
        adjacent.forEach {
            if (visited[it].not()) {
                if (nodeLabels[it] == char) {
                    result.add(it)
                }
            }
        }
        return result

    }


    override fun toString(): String {
        return adjacencyList.contentDeepToString() + "\n" + nodeLabels.contentDeepToString()
    }

    fun reset() {
        visited.forEachIndexed { index, b ->
            visited[index] = false
        }
    }


}

data class Move(val x: Int, val y: Int)



