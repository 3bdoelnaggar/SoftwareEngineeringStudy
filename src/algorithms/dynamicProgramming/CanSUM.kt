package algorithms.dynamicProgramming


fun main() {
    println(canSum(7, arrayOf(2,3)))
    println(canSum(7, arrayOf(5,3,4,7)))
    println(canSum(300, arrayOf(7,14)))
    println(canSum(300, arrayOf(7,14),HashMap()))

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

fun canSum(targetNum: Int, numbers: Array<Int>, knowledge:HashMap<Int,Boolean>): Boolean {
    if(knowledge.containsKey(targetNum)){
        return knowledge[targetNum]!!
    }
    if (targetNum == 0) return true
    if (targetNum < 0) return false
    numbers.forEach {
        val result = canSum(targetNum - it, numbers,knowledge)
        knowledge[targetNum] = result
        if (result) {
            return true
        }
    }
    return false
}