package practice

import java.util.*
import kotlin.collections.ArrayList

/*
problems
1-https://www.hackerearth.com/practice/algorithms/graphs/graph-representation/practice-problems/algorithm/so-np-c559f406/
 */

fun main() {
    val input = arrayOf("aaey,rrum,tgmn,ball", "all,ball,mur,raeymnl,tall,true,trum")
    val arrayOfWords = input[1].split(",")

    val adjacentMatrix = input[0].split(",").map { it.toCharArray().toTypedArray() }.toTypedArray()
    adjacentMatrix.forEach {
        println(it.contentDeepToString())
    }
    val arrayOfAllChars = ArrayList<Char>(16)
    adjacentMatrix.forEach { array ->
        array.forEach {
            arrayOfAllChars.add(it)
        }
    }
    println("All characters ${arrayOfAllChars.toTypedArray().contentToString()}")


    val adjMatrix = arrayOf(
/*                a  a  e  y  r  r  u  m  t  g  m  n  b  a  l  l                                       */
        arrayOf /*a*/(0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf /*a*/(1, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf /*e*/(0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0),
        arrayOf /*y*/(0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0),

        arrayOf /*r*/(1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0),
        arrayOf /*r*/(1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0),
        arrayOf /*u*/(0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0),
        arrayOf /*m*/(0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0),

        arrayOf /*t*/(0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0),
        arrayOf /*g*/(0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0),
        arrayOf /*m*/(0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1),
        arrayOf /*n*/(0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 1, 1),

        arrayOf /*b*/(0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0),
        arrayOf /*a*/(0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0),
        arrayOf /*l*/(0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1),
        arrayOf /*l*/(0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 1, 0)
    )


//    var visited = Array(16) { 0 }
//    fun recurse(node: Int, preChars: String) {
//        val newPreChars = preChars + arrayOfAllChars[node]
//        println(newPreChars)
//        visited[node] = 1
//        for (i in 0..15) {
//            if (i == node) {
//                continue
//            } else {
//                if (adjMatrix[node][i] == 1) {
//                    if (visited[i] == 0)
//                        recurse(i, newPreChars)
//                }
//
//            }
//        }
//    }
//    for (x in 0..15) {
//        recurse(x, "")
//        visited = Array(16) { 0 }
//        println()
//    }
//    println("")
//    arrayOfWords.forEach {
//        if (fullWord.contains(it)) {
//            println("Found $it")
//        } else {
//            println("Didn't  Found $it")
//
//        }
//    }
    println(dfsRecursive(adjMatrix,0,ArrayList()))

}

fun dbs(adjMatrix: Array<Array<Int>>, nodesInIndices: Array<Char>) {
    val stack = Stack<Int>()
    stack.push(0)

    while (stack.isEmpty().not()) {
        val node = stack.peek()

    }
}

fun dfs(adjMatrix: Array<Array<Int>>, vertex: Int){
        


}

fun dfsRecursive(adjMatrix: Array<Array<Int>>, vertex: Int, path: ArrayList<Int>) {
    path.add(vertex)
    println(path)

   loop@ for (i in 0..15) {
        if (i == vertex) {
            continue
        } else {
            if (path.contains(i).not()) {
                if (adjMatrix[vertex][i] == 1) {
                    dfsRecursive(adjMatrix, i, path)
                }


            }
        }
    }
//    return localPath
}

fun convertArrayOfArraysToAdjacencyMatrix(arrayOfAllChars: Array<Array<Char>>): Array<Array<Int>> {
    val adjMatrix = Array(16) { Array(16) { 0 } }
    for (i in 0..15) {
        for (j in 0..15) {
        }
    }
    return adjMatrix
}