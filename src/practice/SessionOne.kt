package practice

import java.util.*
import kotlin.math.absoluteValue


/* problems  session 1
1-https://www.hackerrank.com/challenges/array-left-rotation/problem
2-https://www.hackerrank.com/challenges/sparse-arrays/problem
3-https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
4-https://www.hackerrank.com/challenges/balanced-brackets/problem
 */


fun sessionOneRunner() {
    println(isBalanced("{[(])}"))

}

fun rotateLeft(d: Int, arr: Array<Int>): Array<Int> {
    // Write your code here
    val newArray = Array(arr.size) { 0 }
    arr.forEach {i ->
        var newIndex = i - d - 1
        if (newIndex < 0) {
            newIndex += arr.size
        }
        newArray[newIndex] = i
    }
    return newArray

}

fun isBalanced(s: String): String {
    val open = arrayOf('{', '(', '[')
    val close = arrayOf('}', ')', ']')

    val stack = Stack<Char>()

    s.forEach {
        if (it in open) {
            stack.push(it)
        } else {
            try {
                val char = stack.pop()
                val closedIndex = close.find(it)
                if (closedIndex == -1) {
                    return "NO"
                } else {
                    val openIndex = open.find(char)
                    if (closedIndex == -1) {
                        return "NO"
                    } else {
                        if (closedIndex != openIndex) {
                            return "NO"
                        }
                    }
                }
            }catch (e:Exception){
                return "NO"
            }
        }

    }
    if (stack.empty()) {
        return "YES"
    } else {
        return "NO"
    }

}

fun Array<Char>.find(char: Char): Int {
    this.forEachIndexed { index, c ->
        if (c == char) {
            return index
        }
    }
    return -1
}