package dataStructures.bitmap

import java.util.*

fun main() {
    val bitSet = BitSet(1000000000)
    for(i in 0 until bitSet.size()){
        bitSet.set(i,Random().nextBoolean())
    }

    println(bitSet.cardinality())
}