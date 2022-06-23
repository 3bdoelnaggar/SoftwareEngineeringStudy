package practice

import kotlin.math.absoluteValue


/*
problems
0-https://www.hackerrank.com/challenges/minimum-distances/problem
1-https://www.hackerrank.com/challenges/queens-attack-2/problem
2-https://www.hackerrank.com/challenges/non-divisible-subset/problem
3-https://www.hackerrank.com/challenges/the-time-in-words/problem
 */



fun sessionThreeRunner() {

    println(nonDivisibleSubset(3, arrayOf(1, 7, 2, 4)))
    println(nonDivisibleSubset(7, arrayOf(278, 576, 496, 727, 410, 124, 338, 149, 209, 702, 282, 718, 771, 575, 436)))

}


fun nonDivisibleSubset(k: Int, s: Array<Int>): Int {
    var maximum = 0
    val mapOfTowPairs = HashMap<Int, HashSet<Int>>()
    for (x in s.indices) {
        for (y in s.indices) {
            if (x == y) {
                continue
            }
            if (((s[x] + s[y]) % k) != 0) {
                if (mapOfTowPairs[s[x]] == null) {
                    mapOfTowPairs[s[x]] = HashSet()
                }
                mapOfTowPairs[s[x]]!!.add(s[y])
            }
        }
    }
    println(mapOfTowPairs.toString())

    for (x in mapOfTowPairs.keys) {
        for (y in mapOfTowPairs.keys) {
            if (x == y) {
                continue
            } else {
                val xSet = mapOfTowPairs[x]
                val ySet = mapOfTowPairs[y]
                if (xSet!!.contains(y)) {
                    val size = (xSet.intersect(ySet!!.toList()).size)
                    println("size:$size")
                    if (maximum < size) {
                        maximum = size
                    }
                } else {
                    continue
                }
            }
        }
    }
    return maximum
}

enum class Operation {
    MINUS, PLUS, STILL
}

data class Route(val num: Int, val operationX: Operation, val operationY: Operation)

fun queensAttack(n: Int, k: Int, r_q: Int, c_q: Int, obstacles: Array<Array<Int>>): Int {

    val obstaclesMap = HashMap<String, Int>()
    obstacles.forEach {
        obstaclesMap.put("" + it[0] + "-" + it[1], 0)
    }

    val routes = arrayOf(
            Route(num = 0, operationX = Operation.STILL, operationY = Operation.PLUS)
            , Route(num = 1, operationX = Operation.PLUS, operationY = Operation.PLUS)
            , Route(num = 2, operationX = Operation.PLUS, operationY = Operation.STILL)
            , Route(num = 3, operationX = Operation.PLUS, operationY = Operation.MINUS)
            , Route(num = 4, operationX = Operation.STILL, operationY = Operation.MINUS)
            , Route(num = 5, operationX = Operation.MINUS, operationY = Operation.MINUS)
            , Route(num = 6, operationX = Operation.MINUS, operationY = Operation.STILL)
            , Route(num = 7, operationX = Operation.MINUS, operationY = Operation.PLUS))

    val x = r_q
    val y = c_q
    var validPoints = 0

    routes.forEach {
        var routStartX = x
        var routStartY = y
        routStartX = when (it.operationX) {
            Operation.MINUS -> routStartX - 1
            Operation.PLUS -> routStartX + 1
            Operation.STILL -> routStartX
        }

        routStartY = when (it.operationY) {
            Operation.MINUS -> routStartY - 1
            Operation.PLUS -> routStartY + 1
            Operation.STILL -> routStartY
        }
        while (routStartX <= n && routStartY <= n && routStartX >= 1 && routStartY >= 1) {
            if (obstaclesMap.containsKey("$routStartX-$routStartY")) {
                routStartX = n + 1
            } else {
                validPoints++
                routStartX = when (it.operationX) {
                    Operation.MINUS -> routStartX - 1
                    Operation.PLUS -> routStartX + 1
                    Operation.STILL -> routStartX
                }

                routStartY = when (it.operationY) {
                    Operation.MINUS -> routStartY - 1
                    Operation.PLUS -> routStartY + 1
                    Operation.STILL -> routStartY
                }
            }

        }
    }
    return validPoints
}


fun isObstacles(routStartX: Int, routStartY: Int, obstacles: Array<Array<Int>>): Boolean {
    obstacles.forEach {
        if (it[0] == routStartX && it[1] == routStartY) {
            return true
        }
    }
    return false
}


fun minimumDistances(a: Array<Int>): Int {

    val mapOfkeyAndReptition = HashMap<Int, Int>()
    var min = Int.MAX_VALUE

    a.forEachIndexed { index, i ->
        val findIndex = mapOfkeyAndReptition.get(i)
        if (findIndex == null) {
            mapOfkeyAndReptition.put(i, index)
        } else {
            val minimum = (index - findIndex).absoluteValue
            if (minimum < min) {
                min = minimum
            }

        }
    }
    return if (min == Int.MAX_VALUE) -1 else min

}
