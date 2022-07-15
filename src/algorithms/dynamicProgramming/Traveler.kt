package algorithms.dynamicProgramming

// Say that you are a traveler on a 2D grid. you begin in the top-left corner and your goal is
// to travel to the bottom right corner. you may only move down or right.


fun main() {
    //println(gridTraveler(3, 3))
    println(gridTraveler(3, 3, HashMap()))
    // println(gridTraveler(18, 18))
    println(gridTraveler(18, 18, HashMap()))


    println(gridTravelerTabulation(3, 3))
    println(gridTravelerTabulation(18, 18))
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

// with tabulation
fun gridTravelerTabulation(m: Int, n: Int): Long {
    val table = Array(m + 1) {
        Array(n + 1) {
            0L
        }
    }

    table[1][1] = 1
    for (i in 0..m) {
        for (j in 0..n) {
            val column = i + 1
            val raw = j + 1
            if (raw < n + 1) {
                table[i][raw] += table[i][j]
            }
            if (column < m + 1) {
                table[column][j] += table[i][j]
            }
        }

    }
    return table.last().last()

}


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

