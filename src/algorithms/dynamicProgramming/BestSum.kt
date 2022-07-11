package algorithms.dynamicProgramming

import com.sun.org.apache.bcel.internal.generic.NEW


fun main() {


    //println(besSum(7, arrayOf(5, 3, 4, 7), HashMap()))
    //println(besSum(8, arrayOf(1, 4, 5)))

    println(bestSumUsingKnowledge(8, arrayOf(1, 4, 5), HashMap()))
     println(bestSumUsingKnowledge(100, arrayOf(1, 2, 5, 25),HashMap()))
    //println(bestSum(3, arrayOf(1, 2, 3), HashMap()))

}

fun besSum(targetSum: Int, numbers: Array<Int>): ArrayList<Int>? {
    if (targetSum == 0) return ArrayList()
    if (targetSum < 0) return null
    var shortest: ArrayList<Int>? = null
    for (number in numbers) {
        val result = besSum(targetSum - number, numbers)
        if (result != null) {
            result.add(number)
            if (shortest == null || shortest.size > result.size) {
                shortest = result
            }
        }

    }
    return shortest
}

//this produces wrong answer I think because coping array versus equaling references
fun bestSum(targetSum: Int, numbers: Array<Int>, knowledge: HashMap<Int, ArrayList<Int>?>): ArrayList<Int>? {

    if (targetSum in knowledge) return knowledge[targetSum]
    if (targetSum == 0) return ArrayList()
    if (targetSum < 0) return null

    var shortest: ArrayList<Int>? = null
    for (number in numbers) {
        val remainder = targetSum - number
        val result = bestSum(remainder, numbers, knowledge)
        if (result != null) {
            result.add(number)
            if (shortest == null || shortest.size > result.size) {
                shortest = result
            }
        }
    }
    knowledge[targetSum] = shortest
    return shortest
}

fun bestSumUsingKnowledge(
    targetSum: Int,
    numbers: Array<Int>,
    knowledge: HashMap<Int, ArrayList<Int>?>
): java.util.ArrayList<Int>? {

    if (targetSum in knowledge) return knowledge[targetSum]
    if (targetSum == 0) return ArrayList()
    if (targetSum < 0) return null

    var shortest: ArrayList<Int>? = null
    for (number in numbers) {
        val newTargetSum = targetSum - number
        val result = bestSumUsingKnowledge(newTargetSum, numbers, knowledge)
        if (result != null) {
            val newArray = ArrayList(result)
            newArray.add(number)
            if (shortest == null || newArray.size < shortest.size) {
                shortest = newArray

            }
        }
    }
    knowledge[targetSum] = shortest
    return shortest
}
