package algorithms.dynamicProgramming


fun main() {
    println(howSum(7, arrayOf(2, 3)))
    println(howSum(300, arrayOf(7, 14)))
    println(howSum(300, arrayOf(7, 14), HashMap()))

}

fun howSum(targetSum: Int, numbers: Array<Int>): ArrayList<Int>? {

    if (targetSum == 0) return ArrayList()
    if (targetSum < 0) return null
    for (number in numbers) {
        val reminderResult = howSum(targetSum - number, numbers)
        if (reminderResult != null) {
            reminderResult.add(number)
            return reminderResult
        }
    }
    return null

}

fun howSum(targetSum: Int, numbers: Array<Int>, knowledge: HashMap<Int, ArrayList<Int>?>): ArrayList<Int>? {

    if (knowledge.containsKey(targetSum)) {
        return knowledge[targetSum]
    }
    if (targetSum == 0) return ArrayList()
    if (targetSum < 0) return null
    for (number in numbers) {
        val reminderResult = howSum(targetSum - number, numbers)
        if (reminderResult != null) {
            reminderResult.add(number)
            knowledge[targetSum] = reminderResult
            return reminderResult
        }
    }
    knowledge[targetSum] = null

    return null

}