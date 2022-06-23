package sorting

import kotlin.random.Random

fun main() {
    val input = Array(10) {
        Random.nextInt(100)
    }
    println(input.contentDeepToString())
    println(quickSort(input).contentDeepToString())
}


fun quickSort(input: Array<Int>): Array<Int> {
    return if (input.size < 2) {
        input
    } else {
        val pivot = input[0]
        val parts = input.sliceArray(1 until input.size).partition {
            it < pivot
        }
        return quickSort(parts.first.toTypedArray()) + pivot + quickSort(parts.second.toTypedArray())
    }
}