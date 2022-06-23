package sorting

fun main(arg: Array<String>) {
    println(selectionSort(arrayOf(1,2,5,6,7,8,9,0)).contentDeepToString())
}


fun selectionSort(input: Array<Int>): Array<Int> {
    for (i in input.indices) {
        var min = i
        for (j in (i + 1) until input.size) {
            if (input[min] > input[j]) {
                min = j
            }
        }
        if (min == i) {
            continue
        }
        val temp = input[i]
        input[i] = input[min]
        input[min] = temp
    }
    return input
}