package practice

import kotlin.math.pow


fun main(){

    val input = "23918572 697437974 605819664 966409256 973431103 658927364 454510570 729129860 786555238 30180035"
  val inputs =  input.split(" ").map { it.trim().toLong() }
    inputs.forEach {
        println(summingSeries(it))
    }
}

fun summingSeries(n: Long): Int {
    return ((n.toBigDecimal()*n.toBigDecimal())%(10.toDouble().pow(9)+7).toBigDecimal()).toInt()

}

fun t(n: Long): Long {
    val toLong = (n.toDouble().pow(2) - (n - 1).toDouble().pow(2)).toLong()
    println(toLong)
    return toLong
}

