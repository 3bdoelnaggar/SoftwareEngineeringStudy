package practice

import java.lang.StringBuilder
import kotlin.math.max


fun main(){
    println(alternate("beabeefeab"))
}


fun alternate(s: String): Int {
    val arrayOfChars = s.toCharArray().toSet().toCharArray()
    var max = 0
    for (index in 0..arrayOfChars.size - 2) {
        val firstChar = arrayOfChars[index]
        for (indexPlusOne in (index + 1) until arrayOfChars.size) {
            val secondChar = arrayOfChars[indexPlusOne]
            val stringWithOnlyTwoChars = removeEveryCharBut(firstChar, secondChar, s)
            val isValidString = isValidString(stringWithOnlyTwoChars)
            if (isValidString) {
                if (max < stringWithOnlyTwoChars.length) {
                    max = stringWithOnlyTwoChars.length
                }
            }
        }
    }
    return max
}

fun isValidString(stringWithOnlyTwoChars: String): Boolean {
    for (index in 0..stringWithOnlyTwoChars.length - 2) {
        val firstChar = stringWithOnlyTwoChars[index]
        val secondChar = stringWithOnlyTwoChars[index + 1]
        if (firstChar == secondChar) {
            return false
        }
    }
    return true
}

fun removeEveryCharBut(firstChar: Char, secondChar: Char, s: String): String {
    val builder = StringBuilder()
    s.forEach {
        if (it == firstChar || it == secondChar) {
            builder.append(it)
        }
    }
    return builder.toString()
}
