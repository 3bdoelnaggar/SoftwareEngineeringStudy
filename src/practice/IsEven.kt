package practice


fun main() {
    isEven(5)
    isEven(4)
    isEven(100)
    isEven(101)
    println("isEvenWithModulo")
    isEvenWithModulo(5)
    isEvenWithModulo(4)
    isEvenWithModulo(100)
    isEvenWithModulo(101)
}

//Is Even by checking the least significant bit if 0 even 1 odd
fun isEven(number: Int): Boolean {
    val startTime = System.currentTimeMillis()
    println("number: $number")
    val binaryRepresentation = Integer.toBinaryString(number)
    println("binaryRepresentation: $binaryRepresentation")
    val isEven = binaryRepresentation.last() == '0'
    println("isEven: $isEven")
    println("Time: ${System.currentTimeMillis() - startTime}")
    println("_____________________")
    return isEven
}

fun isEvenWithModulo(number: Int): Boolean {
    val startTime = System.currentTimeMillis()
    println("number: $number")
    val isEven = number % 2 == 0
    println("isEven: $isEven")
    println("Time: ${System.currentTimeMillis() - startTime}")
    println("_____________________")
    return isEven
}