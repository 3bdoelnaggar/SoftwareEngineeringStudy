package algorithms.dynamicProgramming

// Say that you are a traveler on a 2D grid. you begin in the top-left corner and your goal is
// to travel to the bottom right corner. you may only move down or right.


fun main() {
    println(gridTraveler(3, 3))
    println(gridTraveler(3, 3, HashMap()))
    println(gridTraveler(18, 18))
    println(gridTraveler(18, 18, HashMap()))
}


// without memoization
fun gridTraveler(m: Int, n: Int): Long {
    if (m == 0 || n == 0) {
        return 0
    }
    if (m == 1 || n == 1) {
        return 1
    }

    return gridTraveler(m - 1, n) + gridTraveler(m, n - 1)
}


// without memoization
fun gridTraveler(m: Int, n: Int, knowledge: HashMap<String, Long>): Long {
    val keyNM = "$n,$m"
    val keyMN = "$m,$n"

    if (knowledge.containsKey(keyNM)) {
        return knowledge[keyNM]!!
    }

    if (knowledge.containsKey(keyMN)) {
        return knowledge[keyMN]!!
    }
    if (m == 0 || n == 0) {
        return 0
    }
    if (m == 1 || n == 1) {
        return 1
    }

    val result = gridTraveler(m - 1, n, knowledge) + gridTraveler(m, n - 1, knowledge)
    knowledge[keyNM] = result
    return result
}

