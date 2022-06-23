package dataStructures.graph

import java.util.*


fun main() {
    val graph=GraphAdjacencyList()
    graph.addEdge(1,3)
    graph.addEdge(2,4)
    graph.addEdge(3,8)
    graph.addEdge(1,5)
    graph.addEdge(2,5)
    graph.depthFirstSearch(1)

}

class GraphAdjacencyList {
    private val adjacencyList = Array<LinkedList<Int>>(16) {
        LinkedList()
    }
    private val visited = Array(16) {
        false
    }

    fun addEdge(vertex: Int, adjacent: Int) {
        adjacencyList[vertex].add(adjacent)
    }

    fun depthFirstSearch(vertex: Int) {
        println(vertex)
        visited[vertex]=true
        adjacencyList[vertex].forEach{
            if(visited[it].not()){
                depthFirstSearch(it)
            }
        }
    }

}
