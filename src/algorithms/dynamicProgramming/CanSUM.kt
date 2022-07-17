package algorithms.dynamicProgramming


fun main() {
    println(canSum(7, arrayOf(2, 3)))
    println(canSum(7, arrayOf(5, 3, 4, 7)))
    println(canSum(300, arrayOf(7, 14)))
    println(canSum(300, arrayOf(7, 14), HashMap()))


    println(canSumTabulation(7, arrayOf(2, 3)))
    println(canSumTabulation(7, arrayOf(5, 3, 4, 7)))

    println(canSumTabulation(300, arrayOf(7, 14)))


}

fun canSum(targetNum: Int, numbers: Array<Int>): Boolean {
    if (targetNum == 0) return true
    if (targetNum < 0) return false
    numbers.forEach {
        val result = canSum(targetNum - it, numbers)
        if (result) {
            return true
        }
    }
    return false
}

fun canSum(targetNum: Int, numbers: Array<Int>, knowledge: HashMap<Int, Boolean>): Boolean {
    if (knowledge.containsKey(targetNum)) {
        return knowledge[targetNum]!!
    }
    if (targetNum == 0) return true
    if (targetNum < 0) return false
    numbers.forEach {
        val result = canSum(targetNum - it, numbers, knowledge)
        knowledge[targetNum] = result
        if (result) {
            return true
        }
    }
    return false
}


fun canSumTabulation(targetNum: Int, numbers: Array<Int>): Boolean {

    val table = Array(targetNum + 1) { false }
    table[0] = true
    table.forEachIndexed { index, value ->
        if (value /* aka value == true*/) {
            numbers.forEach {
                if (index + it < table.size) {
                    table[index + it] = true
                }
            }
        }
    }

    return table.last()
}