package practice

import java.io.*;
import java.util.*;

/**
 * You are given a sorted array with a length N, containing only of 0 or 1 integer values.
 * Find an index of the first 1 value.
 *
 * Example:
 * Input: array: [0, 0, 0, 0, 0, 1, 1, 1]
 *
 * Output:
 *  5
 **/

fun main() {

    print(findOneIndex(arrayOf(0, 0, 0, 0, 0, 0, 1, 1)))

}

fun findOneIndex(input: Array<Int>): Int {
    var start = 0
    var end = input.size - 1

    while (start <= end) {
        val mid = (end + start) / 2
        if (input[mid] == 1) {
            if (input[mid - 1] == 0) return mid
            end = mid - 1

        } else {
            start = mid + 1
        }
    }

    return -1
}