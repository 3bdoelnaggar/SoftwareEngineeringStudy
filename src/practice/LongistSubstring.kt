package practice

import kotlin.math.max
import kotlin.system.measureNanoTime

fun main() {
//    ayaSolution("bbbbbb")
//    ayaSolutionUpdate("bbbbbb")

    println(measureNanoTime {
        println(lengthOfLongestSubstring2("abba"))
    })

    println(measureNanoTime {
        println(ayaSolution("abba"))
    })


}


fun lengthOfLongestSubstring2(s: String): Int {
    val charLastIndexMap = HashMap<Char, Int>()
    var lastUniqueCharacterising = 0

    var longestSubstring = 0

    for (i in s.indices) {
        if (charLastIndexMap.contains(s[i])) {
            val size = i - lastUniqueCharacterising
            if (longestSubstring < size) {
                longestSubstring = size
            }
            lastUniqueCharacterising = charLastIndexMap[s[i]]!! + 1

        }
        charLastIndexMap[s[i]] = i
    }
    println(charLastIndexMap.toString())

    val size = s.length - lastUniqueCharacterising
    if (longestSubstring < size) {
        longestSubstring = size
    }

    return longestSubstring
}


fun lengthOfLongestSubstring(s: String): Int {
    var stringBuilder = StringBuilder()
    var maxLen = 0
    val chars = HashMap<Char, Int>()

    for (i in s.indices) {
        if (chars.contains(s[i])) {
            if (stringBuilder.length > maxLen) {
                maxLen = stringBuilder.length
            }
            stringBuilder.delete(0, chars[s[i]]!!)
            chars.clear()
            chars[s[i]] = i
            stringBuilder.forEachIndexed { index, c ->
                chars[c] = index
            }
        } else {
            stringBuilder.append(s[i])
            chars[s[i]] = i
        }
    }
    return maxLen
}

fun ayaSolutionUpdate(s: String): Int {
    var maxLen = 0
    val time = measureNanoTime {
        var subString = StringBuilder()
        var charIndex = HashMap<Char, Int>()
        for (i in s.indices) {
            if (charIndex.contains(s[i])) {
                maxLen = max(maxLen, subString.length)

                val i = charIndex[s[i]]!!
                subString = subString.delete(0, i + 1)
                charIndex = HashMap<Char, Int>()
                subString.forEachIndexed { index, c ->
                    charIndex[c] = index
                }
            }
            subString.append(s[i])
            charIndex[s[i]] = subString.length - 1
        }
        maxLen = max(maxLen, subString.length)
    }
    println("time: $time")
    return maxLen
}

fun ayaSolution(s: String): Int {
    var subString = ""
    var maxLen = 0
    for (c in s) {
        if (subString.contains(c)) {
            val i = subString.indexOfFirst { it == c }
            subString = subString.removeRange(0, i + 1)
        }
        subString += c
        maxLen = max(maxLen, subString.length)
    }

    return maxLen
}






