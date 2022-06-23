package practice

import kotlin.math.pow

fun main() {
    print(e(15))
}


fun e(t: Long): Long {
    var i = 0
    while ((t + 2) >= 3 * (2.0.pow(i.toDouble()))) {
        i++
    }
    val cycleStartValue = 3 * (2.0.pow(i.toDouble()-1))
    val time = cycleStartValue - 2

    return Math.abs((t-time) - cycleStartValue).toLong()
}