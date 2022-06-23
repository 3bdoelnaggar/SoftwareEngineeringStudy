package practice

import java.util.HashMap


fun main() {
    print(ramyEqual3(arrayOf(2, 5, 5,5,5,5)))
}


fun repetitionEqual(arr: Array<Int>): Int {
    var rounds = 0
    val numRepetition = HashMap<Int, Int>()
    arr.forEach {
        var repetitions = numRepetition[it]
        if (repetitions != null) {
            repetitions++
            numRepetition[it] = repetitions

        } else {
            numRepetition[it] = 1
        }
    }
    val numbersWithoutRepetitionSorted = numRepetition.keys.sorted()
    for (x in 0..numbersWithoutRepetitionSorted.size - 2) {
        val smallNumber = numbersWithoutRepetitionSorted[x]
        val smallNumRepetition = numRepetition[smallNumber]
        val bigNumber = numbersWithoutRepetitionSorted[x + 1]
        val bigNumRepetition = numRepetition[bigNumber]
        val diff = bigNumber - smallNumber
        if (smallNumRepetition!! >= bigNumRepetition!!) {
            rounds += calcRound(diff) * bigNumRepetition
        } else {
            rounds += if (diff == 5 || diff == 2 || diff == 1) {
                calcRound(diff) * bigNumRepetition
            } else {
                var r = 1
                if (diff > 5) {
                    r = diff / 5
                }
                (r * bigNumRepetition) + 1
            }
        }
    }

    return rounds

}

fun solutionBySubtraction(input: Array<Int>): Int {
    var rounds = 0
    var sortedArray = input.sortedArray()
    while (true) {
        val diff = sortedArray[sortedArray.size - 1] - sortedArray[0]

        if (diff == 0) {
            return rounds
        }
        when {
            diff >= 5 -> {
                sortedArray[sortedArray.size - 1] -= 5
            }
            diff >= 2 -> {
                sortedArray[sortedArray.size - 1] -= 2
            }
            else -> {
                sortedArray[sortedArray.size - 1] -= 1
            }
        }
        sortedArray = sortedArray.sortedArray()
        rounds++
    }
}

fun ramyEqual2(arr: Array<Int>): Int {

    fun calcRound(diff: Int): Int {
        val set = arrayOf(5, 2, 1)
        val rounds = diff / set[0] + (diff % set[0]) / set[1] + ((diff % set[0]) % set[1]) / set[2]
        return rounds
    }

    var rounds = 0
    val sortedArray = arr.sortedArray()

    val smallest = sortedArray[0]
    for (x in sortedArray.size - 1 downTo 1) {
        val diff = sortedArray[x] - smallest
        rounds += calcRound(diff)
    }
    return rounds;
}

fun ramyEqual3(arr: Array<Int>): Int {

    fun calcRound(diff: Int): Int {
        val set = arrayOf(5, 2, 1)
        val rounds = diff / set[0] + (diff % set[0]) / set[1] + ((diff % set[0]) % set[1]) / set[2]
        return rounds
    }
    var smallestRounds = Int.MAX_VALUE
    val sortedArray = arr.sortedArray()
    var smallest = sortedArray[0]
    for (decrease in 0..2) {
        var rounds = 0
        smallest -= decrease
        for (x in arr.indices) {
            val diff = sortedArray[x] - smallest
            rounds += calcRound(diff)
        }
        if(rounds<smallestRounds){
            smallestRounds=rounds
        }
        smallest=sortedArray[0]
    }
    return smallestRounds
}


fun repetitionSolution(arr: Array<Int>): Int {

    val numRepetition = HashMap<Int, Int>()
    arr.forEach {
        var repetitions = numRepetition[it]
        if (repetitions != null) {
            repetitions++
            numRepetition[it] = repetitions
        } else {
            numRepetition[it] = 1
        }
    }

    fun calcRound(diff: Int): Int {
        val set = arrayOf(5, 2, 1)
        val rounds = diff / set[0] + (diff % set[0]) / set[1] + ((diff % set[0]) % set[1]) / set[2]
        return rounds
    }

    var rounds = 0
    val sortedArray = numRepetition.keys.toTypedArray().sortedArray()

    val smallest = sortedArray[0]
    for (x in sortedArray.size - 1 downTo 1) {
        val diff = sortedArray[x] - smallest
        val repetitions = numRepetition[sortedArray[x]]!!

        if (repetitions > 1 && diff % 5 == 3 || diff % 5 == 4) {
            val fives = diff / 5
            rounds += (repetitions * (fives + 1)) + 1
        } else {
            rounds += calcRound(diff) * repetitions
        }
    }

    return rounds


}


fun equal(arr: Array<Int>): Int {
    var round = 0

    val numRepetition = HashMap<Int, Int>()
    arr.forEach {
        var repetitions = numRepetition[it]
        if (repetitions != null) {
            repetitions++
            numRepetition[it] = repetitions

        } else {
            numRepetition[it] = 1
        }
    }
    val sortedArray = numRepetition.keys.sorted()
    val smallest = sortedArray[0]
    for (x in (sortedArray.size - 1) downTo 1) {
        if (smallest == sortedArray[x]) {
            return round
        } else {
            val smallNumRepetition = numRepetition[smallest]
            val bigNumber = sortedArray[x]
            val bigNumRepetition = numRepetition[bigNumber]
            val diff = sortedArray[x] - smallest
            if (smallNumRepetition!! >= bigNumRepetition!!) {
                round += calcRound(diff) * bigNumRepetition
            } else {
                round += when (diff % 5) {
                    0 -> {
                        calcRound(diff) * bigNumRepetition
                    }
                    1 -> {
                        calcRound(diff) * bigNumRepetition
                    }
                    2 -> {
                        calcRound(diff) * bigNumRepetition
                    }
                    3 -> {
                        (((diff / 5) + 1) * bigNumRepetition) + 1
                    }
                    4 -> {
                        (((diff / 5) + 1) * bigNumRepetition) + 1

                    }
                    else -> {
                        0
                    }
                }
            }
        }
    }

    return round

}


fun calcRound(diff: Int): Int {
    val set = arrayOf(5, 2, 1)
    val rounds = diff / set[0] + (diff % set[0]) / set[1] + ((diff % set[0]) % set[1]) / set[2]
    return rounds
}


