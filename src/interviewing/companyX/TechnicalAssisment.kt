package interviewing.companyX

import kotlin.math.min

/**
 * technical assessment it was a hackerrank problem-solving contains three problems
 * it was like between easy and medium problems
 */


/*
    Given an array of binary digits, 0 and 1 , sort the array so that all zeros are ar one end and all ones are ata the other,
    which end doesn't matter. to sort array swap any adjacent two elements. determine the minimum swap to sort the array.
    Example
    array=[0,1,0,1
    with one swap, switching element 1 and 2 yields [0,0,1,1], a sorted array.
 */

// what I need to solve the problem it looks like a bubble sort let try it


fun main() {
    print(minimumSwaps(arrayOf(0, 1, 0, 1).map { it.toString() }.reduce { acc, s -> acc + s }))
    print("\n")
    print(minimumSwaps(arrayOf(1, 1, 1, 1, 0, 0, 0, 0).map { it.toString() }.reduce { acc, s -> acc + s }))
    print("\n")
    print(minimumSwaps(arrayOf(0, 1, 1, 0).map { it.toString() }.reduce { acc, s -> acc + s }))
    print(minimumSwaps(arrayOf(0, 1, 1, 0).map { it.toString() }.reduce { acc, s -> acc + s }))
    println("______________________________________minimum")
    println(minimumUniqueSum(arrayOf(3, 2, 1, 2, 7)))

    println("_______________________________ isPossible")
    println(isPossible7(1, 2, 5, 3))

    println(isPossible4(1, 2, 5, 3))

    println(isPossible7(1, 1, 1, 1))


}

fun solution(arrayOf: Array<Int>): Int {
    var zerosFirstSwappingCount = 0
    val zerosClone = arrayOf.clone()

    for (i in zerosClone.size - 1 downTo 1) {
        for (j in 0 until i) {
            if (zerosClone[j] > zerosClone[j + 1]) {
                val temp = zerosClone[j]
                zerosClone[j] = zerosClone[j + 1]
                zerosClone[j + 1] = temp
                zerosFirstSwappingCount++
            }
        }
    }


    var onesFirstSwappingCount = 0
    val onesClone = arrayOf.clone()


    for (i in onesClone.size - 1 downTo 1) {
        for (j in 0 until i) {
            if (onesClone[j] < onesClone[j + 1]) {
                val temp = onesClone[j]
                onesClone[j] = onesClone[j + 1]
                onesClone[j + 1] = temp
                onesFirstSwappingCount++
            }
        }
    }
    return min(zerosFirstSwappingCount, onesFirstSwappingCount)
}


fun insertionSort(binaries: Array<Byte>): Int {
    var numberOfSwaps = 0
    for (i in 1 until binaries.size) {
        var j = i - 1
        val element = binaries[i]
        while (j >= 0 && element < binaries[j]) {
            binaries[j + 1] = binaries[j]
            binaries[j] = element
            j--
            numberOfSwaps++
        }
    }
    return numberOfSwaps
}

//Ramy solution
fun minimumSwaps(s: String): Int {
    var ones = 0
    var zeros = 0
    var onesCounter = 0
    var zerosCounter = 0
    for (i in s.indices) {
        if (s[i] == '1') {
            onesCounter += i - ones
            ones++
        } else {
            zerosCounter += i - zeros
            zeros++
        }
    }
    return if (zerosCounter > onesCounter) onesCounter else zerosCounter
}


/**
 * is possible
 * Consider a pair of integers, [a,b] the following operation can be performed on [a,b] in any order, zero or more times.
 * (a,b) => (a+b,b)
 * (a,b) => (a,b+a)
 * return string that denotes weather or not (a,b) can be converted to (c,d) by performing the operation zero or more times.
 * Example
 * (a,b) = (1,1)
 * (c,d) = (5,2)
 * Perform the operation (1, 1+ 1) to get (1, 2) perform the
 * operation (1+2, 2) to get (3, 2) and perform the operation (3+2, 2)
 * to get (5, 2). Alternatively, the first operation could be (1+1, 1) to
 * get (2, 1) and so on
 */


fun isPossible4(a: Int, b: Int, c: Int, d: Int): String {
    var result = "No"
    fun isPos(a: Int, b: Int) {
        if (a == c && b == d) {
            result = "Yes"
            return
        }
        if (a > c || b > d) {
            return
        }

        isPos(a + b, b)
        isPos(a, b + a)

    }
    isPos(a, b)
    return result
}

fun isPossible7(a: Int, b: Int, c: Int, d: Int): String {
    if (a == c && b == d) {
        return "Yes"
    }

    if (a > c || b > d) {
        return "No"
    }
    val result1 = isPossible7(a + b, b, c, d)
    val result2 = isPossible7(a, b + a, c, d)
    if (result1 == "Yes") return result1
    if (result2 == "Yes") return result2
    return "No"
}

fun isPossible5(a: Int, b: Int, c: Int, d: Int): String {
    var result = "No"
    var currentC = c
    var currentB = d


    while (currentC != 0 && currentB != 0) {
        if (currentC > currentB) {
            currentC -= currentB
        } else {
            currentB -= currentC
        }
        if (a == currentC && currentB == b) {
            return "Yes"
        }
    }
    return result
}


fun minimumUniqueSum(arr: Array<Int>): Int {
    val map = HashMap<Int, Int>()
    arr.forEach {
        var numTobeUnique = it
        while (map[numTobeUnique] != null) {
            numTobeUnique++
        }
        map[numTobeUnique] = 1
    }
    return map.keys.reduce { acc, i -> acc + i }
}


/**
 * is possible
 * Consider a pair of integers, [a,b] the following operation can be performed on [a,b] in any order, zero or more times.
 * (a,b) => (a+b,b)
 * (a,b) => (a,b+a)
 * return string that denotes weather or not (a,b) can be converted to (c,d) by performing the operation zero or more times.
 * Example
 * (a,b) = (1,1)
 * (c,d) = (5,2)
 * Perform the operation (1, 1+ 1) to get (1, 2) perform the
 * operation (1+2, 2) to get (3, 2) and perform the operation (3+2, 2)
 * to get (5, 2). Alternatively, the first operation could be (1+1, 1) to
 * get (2, 1) and so on
 */


fun isPossible(a: Int, b: Int, c: Int, d: Int): String {
    var result = "No"
    fun isPos(a: Int, b: Int) {
        if (a == c && b == d) {
            result = "Yes"
            return
        }
        if (a > c || b > d) {
            return
        }

        isPos(a + b, b)
        isPos(a, b + a)

    }
    isPos(a, b)
    return result
}

fun isPossible2(a: Int, b: Int, c: Int, d: Int): String {
    var result = "No"
    var Cc = c
    var Cb = d


    while (Cc != 0 && Cb != 0) {
        if (Cc > Cb) {
            Cc -= Cb
        } else {
            Cb -= Cc
        }
        if (a == Cc && Cb == b) {
            return "Yes"
        }
    }
    return result
}




