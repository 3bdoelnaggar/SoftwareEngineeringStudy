package practice

import java.util.TreeMap
import kotlin.math.max
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis
import kotlin.time.measureTime

fun main() {
    ayaSolution("bbbbbb")
    ayaSolutionUpdate("bbbbbb")



}




fun lengthOfLongestSubstring(s: String): Int {
    var stringBuilder = StringBuilder()
    var maxLen   = 0
    val chars = HashMap<Char,Int>()

    for (i  in s.indices){
        if(chars.contains(s[i])){
            if(stringBuilder.length>maxLen) {
                maxLen =  stringBuilder.length
            }
            stringBuilder.delete(0,chars[s[i]]!!)
            chars.clear()
            chars[s[i]] = i
            stringBuilder.forEachIndexed{index, c ->
            chars[c]=index
            }
        }else{
            stringBuilder.append(s[i])
            chars[s[i]]=i
        }
    }
    return maxLen
}

fun ayaSolutionUpdate(s:String): Int {
    var maxLen  = 0
    val time = measureNanoTime {
        var subString = StringBuilder()
        var charIndex = HashMap<Char,Int>()
        for (i in s.indices){
        if(charIndex.contains(s[i])) {
            maxLen = max(maxLen,subString.length)

            val i = charIndex[s[i]]!!
            subString = subString.delete(0, i+1)
            charIndex = HashMap<Char,Int>()
            subString.forEachIndexed { index, c ->
                charIndex[c]= index
            }
        }
        subString.append(s[i])
        charIndex[s[i]] = subString.length-1
    }
    maxLen = max(maxLen,subString.length)
    }
    println("time: $time")
    return maxLen
    }

fun ayaSolution(s:String): Int {
    var subString = ""
    var maxLen = 0
val time = measureNanoTime {
    for (c in s) {
        if (subString.contains(c)) {
            val i = subString.indexOfFirst { it == c }
            subString = subString.removeRange(0, i + 1)
        }
        subString += c
        maxLen = max(maxLen, subString.length)
    }
}
    println("time: $time")

    return maxLen
}






