package practice

import java.util.*
import kotlin.collections.ArrayList

fun main(args: Array<String>) {
    val input = arrayOf("aaey,rrum,tgmn,ball", "all,ball,mur,raeymnl,tall,true,trum")
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

    input[1].split(",").forEach { word ->
        val firstCharIndices = findIndices(graph.nodeLabels.toList(), word[0])
        if (firstCharIndices.isEmpty()) {
            println("cant create word $word")
        } else {
            firstCharIndices.forEach {
                graph.canWeCreateThisWord(word, it)
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

    val adjacencyList = ArrayList<ArrayList<Node>>()
    val charsList = ArrayList<Char>()
    val result = Pair<List<Char>, ArrayList<ArrayList<Node>>>(charsList, adjacencyList)

    val graph = ThisGraph()

    var vertexIndex = 0
    val vertexMatchesIndex = Array(16) {
        '\u0000'
    }
    for (rowIndex in input.indices) {
        for (columnIndex in input[rowIndex].indices) {
            val currentChar = input[rowIndex][columnIndex]
            vertexMatchesIndex[vertexIndex] = currentChar
            val adjacency = ArrayList<Node>()
            //fill adjacency
            adjacentMoves.forEach { move ->
                try {
                    val node = Node()
                    val char = input[rowIndex + move.x][columnIndex + move.y]
                    val adjacentX = rowIndex + move.x
                    val adjacentY = columnIndex + move.y
                    node.value = char
                    adjacency.add(node)
                    val adjacentIndex = (4 * adjacentX) + adjacentY
                    graph.addEdge(vertexIndex, adjacentIndex)
                } catch (exception: Exception) {

                }
            }
            adjacencyList.add(adjacency)
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

    fun depthFirstSearch(node: Int) {
        println(nodeLabels[node])
        visited[node] = true
        adjacencyList[node].forEach {
            if (visited[it].not()) {
                depthFirstSearch(it)

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
                } else {
                    println("visited")
                }
            }

        }
    }


    override fun toString(): String {
        return adjacencyList.contentDeepToString()
    }


}


class Node {
    var value: Char = '\u0000'
    var isVisited = false
    val adjacency: ArrayList<Node> = ArrayList()
    override fun toString(): String {
        return "value:$value"
    }
}

data class Move(val x: Int, val y: Int)


fun explore(node: Node) {
    println(node)
    node.isVisited = true
    node.adjacency.forEach {
        if (node.isVisited.not()) {
            explore(it)
        }
    }
}
