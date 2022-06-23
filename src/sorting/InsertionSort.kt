package sorting

fun main() {

    println(insertionSort(arrayOf(1, 2, 8, 5, 6, 7, 0, -1)).contentToString())

}

fun insertionSort(input: Array<Int>): Array<Int> {
    var endSortedArrayIndex = 0
    for (i in 1 until (input.size)) {
        val startSortedArrayIndex = 0
        for (j in startSortedArrayIndex..endSortedArrayIndex) {
            if (input[j] > input[i]) {
                val temp = input[j]
                input[j] = input[i]
                input[i] = temp
            }
        }
        endSortedArrayIndex++
    }

    return input
}

