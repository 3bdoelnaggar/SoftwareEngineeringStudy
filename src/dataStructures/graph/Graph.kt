package dataStructures.graph

import java.util.LinkedList


fun main() {
    val graph = GraphRevisited(3)

    graph.addEdge(0,2)
    graph.addEdge(1,1)
    graph.addEdge(2,2)
    graph.breadthFirstSearch(2)

}

class GraphRevisited(verticesNumber: Int) {

    private val adjacencyList = Array<LinkedList<Int>>(verticesNumber) {
        LinkedList()
    }

    fun addEdge(vertices: Int, neighbor: Int) {
        adjacencyList[vertices].add(neighbor)
    }

    fun breadthFirstSearch(vertex: Int) {

        val visited = Array(adjacencyList.size) {
            false
        }

        val queue = LinkedList<Int>()
        queue.add(vertex)
        visited[vertex] = true


        while (queue.size != 0) {

            val top = queue.last
            queue.removeLast()

            println(top)

            val adj = adjacencyList[top]

            while (adj.size != 0) {
                val node = adj.last
                if (!visited[node]) {
                    adj.removeLast()
                    visited[node]
                    queue.add(node)
                }

            }


        }


    }


}