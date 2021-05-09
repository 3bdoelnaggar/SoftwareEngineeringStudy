package practice

import java.math.BigInteger


val bigInput=""

fun main() {
    val start = System.currentTimeMillis()
    println(fikyBigSorting(arrayOf("31415926535897932384626433832795", "1")).contentToString())
    val time = System.currentTimeMillis() - start
    println("time:$time")
}

fun bigSorting(unsorted: Array<String>): Array<String> {

    //(n + n log n + n)
    val intArray = ArrayList<Int>()
    val longArray = ArrayList<Long>()
    val bigIntArray = ArrayList<BigInteger>()
    unsorted.forEach {
        val int = it.toIntOrNull()
        if (int != null) {
            intArray.add(int)
        } else {
            val long = it.toLongOrNull()
            if (long != null) {
                longArray.add(long)

            } else {
                bigIntArray.add(BigInteger(it))
            }
        }
    }
    intArray.sort()
    longArray.sort()
    bigIntArray.sort()


    for (i in 0 until intArray.size) {
        unsorted[i] = intArray[i].toString()
    }

    for (x in 0 until longArray.size) {
        unsorted[intArray.size + x] = longArray[x].toString()
    }
    for (y in 0 until bigIntArray.size) {
        unsorted[(intArray.size) + (longArray.size) + y] = bigIntArray[y].toString()
    }
    return unsorted
}







fun fikyBigSorting(unsorted: Array<String>): Array<String> {
    unsorted.sortWith(sortComparable)
    return unsorted
}

val sortComparable = Comparator<String> { one, two ->
    if (one.length < two.length) return@Comparator -1
    if (one.length > two.length) return@Comparator 1

    val maxIntDigit = 9
    if (one.length <= maxIntDigit) {
        return@Comparator one.toInt().compareTo(two.toInt())
    } else {
        var start = 0
        var end = 9

        while (end<one.length&&start<end){
            val oneInt=one.substring(start until end).toInt()
            val twoInt=two.substring(start until end).toInt()
            val compare = oneInt.compareTo(twoInt)
            if(compare!=0){
                return@Comparator compare
            }
            start=end
            end= minOf(end+9,one.length-1)
        }
    }
    return@Comparator 0
}


fun mergeSort(unsortedArray: Array<BigInteger>, left: Int, right: Int) {
    if (left < right) {
        val mid = (left + right) / 2
        mergeSort(unsortedArray, left, mid)
        mergeSort(unsortedArray, mid + 1, right)
        merge(unsortedArray, left, mid, right)
    }

}


fun merge(array: Array<BigInteger>, left: Int, mid: Int, right: Int) {

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

