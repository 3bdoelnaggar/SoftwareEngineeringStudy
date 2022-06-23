package sorting

fun main() {
    val array = arrayOf(3, 5, 6, 7, 22, 88, 44, 55, 66, 77, 88, 99)
    mergeSort(array, 0, array.size - 1)
    println(array.contentToString())

}


fun mergeSort(unsortedArray: Array<Int>, left: Int, right: Int): Array<Int> {
    if (left < right) {
        val mid = (left + right) / 2
        mergeSort(unsortedArray, left, mid)
        mergeSort(unsortedArray, mid + 1, right)
        merge(unsortedArray, left, mid, right)
    }

    return unsortedArray
}

fun merge(array: Array<Int>, left: Int, mid: Int, right: Int) {

    val leftArray = array.copyOfRange(left, mid + 1)
    val rightArray = array.copyOfRange(mid + 1, right + 1)
    val leftArraySize: Int = leftArray.size
    val rightArraySize: Int = rightArray.size

    var leftCursor = 0
    var rightCursor = 0
    var mergedCursor = left
    while (leftCursor < leftArraySize && rightCursor < rightArraySize) {
        if (leftArray[leftCursor] < rightArray[rightCursor]) {
            array[mergedCursor] = leftArray[leftCursor]
            leftCursor++
        } else {
            array[mergedCursor] = rightArray[rightCursor]
            rightCursor++
        }
        mergedCursor++

    }

    while (leftCursor < leftArraySize) {
        array[mergedCursor] = leftArray[leftCursor]
        leftCursor++
        mergedCursor++
    }

    while (rightCursor < rightArraySize) {
        array[mergedCursor] = rightArray[rightCursor]
        rightCursor++
        mergedCursor++
    }

}