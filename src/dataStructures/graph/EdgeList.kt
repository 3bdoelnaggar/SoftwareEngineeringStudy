package dataStructures.graph

import java.util.*

fun main() {
    val graph = Graph(16)
    graph.addEdge(2, 5, 10)
    graph.addEdge(4, 6, 10)
    graph.addEdge(5, 8, 13)
    graph.addEdge(7, 9, 12)

    println(graph.edges.contentDeepToString())
    println("isConnected(5,9):" + graph.isConnected(5, 9))
    println("isConnected(5,8:)" + graph.isConnected(5, 8))

}

class Graph(verticesNumber: Int) {
    data class Edge(val v: Int, val w: Int)

    var edges: Array<LinkedList<Edge>> = Array(verticesNumber) {
        LinkedList<Edge>()
    }

    fun addEdge(u: Int, v: Int, w: Int) {
        edges[u].add(0, Edge(v, w))
    }

    fun isConnected(u: Int, v: Int): Boolean {
        for (edge in edges[u]) {
            if (edge.v == v) {
                return true
            }
        }
        return false
    }

}