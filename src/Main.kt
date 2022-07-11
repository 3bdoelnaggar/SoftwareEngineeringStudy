import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun main(args: Array<String>) {
    println(bestSum(8, arrayOf(1, 4, 5), HashMap()))


}


fun bestSum(targetSum: Int, numbers: Array<Int>, knowledge: HashMap<Int, ArrayList<Int>?>): ArrayList<Int>? {

    if (targetSum in knowledge){
        println(knowledge[targetSum])
        return knowledge[targetSum]
    }
    if (targetSum == 0) return ArrayList()
    if (targetSum < 0) return null

    var shortest: ArrayList<Int>? = null
    for (number in numbers) {
        val remainder = targetSum - number
        val result = bestSum(remainder, numbers, knowledge)
        println("shortest: ${shortest.hashCode()} $shortest")
        if (result != null) {
           val newArray = ArrayList(result).apply {
               add(number)
           }
               if (shortest == null || shortest.size > newArray.size) {
                   shortest = newArray
               }
               println("result: ${result.hashCode()} $result")
           }

        }
    knowledge[targetSum] = shortest
    return shortest
}