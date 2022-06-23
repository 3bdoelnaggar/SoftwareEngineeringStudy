package practice

import kotlin.math.absoluteValue

fun main() {
    println(funnyString("acxz"))
    println(funnyString("bcxz"))
}

fun funnyString(s: String): String {
    val array = Array(s.length - 1) { 0 }
    val array2 = Array(s.length - 1) { 0 }

    for (i in 0..s.length - 2) {
        val diff = s[i].toInt() - s[i + 1].toInt()
        array[i] = diff.absoluteValue
    }
    val reversedString = s.reversed()
    for (i in 0..reversedString.length - 2) {
        val diff = reversedString[i].toInt() - reversedString[i + 1].toInt()
        array2[i] = diff.absoluteValue
    }
    for (i in 0..array.size - 2) {
        if (array[i] == array2[i]) {
            continue
        } else {
            return "Not Funny"
        }
    }
    return "Funny"

}