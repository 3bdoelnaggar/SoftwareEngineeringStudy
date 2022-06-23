package practice

import java.math.BigInteger
import kotlin.math.pow


fun main() {
    println(lightss(7678))
}

fun lights(n: Int): Long {
    // Write your code here
    val long = Math.pow(2.0, n.toDouble()) - 1
    return long.toLong() % 10000000

}

fun lightss(n: Int): Long {
        val result = BigInteger.valueOf(2).pow(n).minus(BigInteger.valueOf(1)).mod(100000.toBigInteger()).toLong()
        return result

}

