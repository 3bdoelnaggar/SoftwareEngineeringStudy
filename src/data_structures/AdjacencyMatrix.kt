package data_structures



/*
    Because each entry in the adjacency matrix requires only one bit, it can be represented in a very compact way
    |V|2/8 bytes to represent a directed graph
     approximately |V|2/16 bytes to represent an undirected graph
     finding all vertices adjacent to a given vertex in an adjacency list is as simple as reading the list
     , and takes time proportional to the number of neighbors. With an adjacency matrix
     , an entire row must instead be scanned, which takes a larger amount of time
     , proportional to the number of vertices in the whole graph. On the other hand
     , testing whether there is an edge between two given vertices can be determined at once with an adjacency matrix
 */
fun main() {
    val oneArray = arrayOf      (1, 1, 0, 0, 1, 0)
    val twoArray = arrayOf      (1, 0, 1, 0, 1, 0)
    val threeArray = arrayOf    (0, 1, 0, 1, 0, 0)
    val fourArray = arrayOf     (0, 0, 1, 0, 1, 1)
    val fiveArray = arrayOf     (1, 1, 0, 1, 0, 0)
    val sixArray = arrayOf      (0, 0, 0, 1, 0, 0)
    val matrix= arrayOf(oneArray,twoArray,threeArray,fourArray,fiveArray,sixArray)


}

