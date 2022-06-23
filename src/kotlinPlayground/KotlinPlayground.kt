package kotlinPlayground

import kotlin.math.abs
import kotlin.math.cos

fun main() {
    findFixPoint()
}

const val eps = 1E-10 // "good enough", could be 10^-15

tailrec fun findFixPoint(x: Double = 1.0): Double {
    println(x)
    return if (abs(x - cos(x)) < eps) x else findFixPoint(cos(x))
}


