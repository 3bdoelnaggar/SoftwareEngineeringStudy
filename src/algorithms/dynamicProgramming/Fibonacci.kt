package algorithms.dynamicProgramming

// fib(n) = fib(n-1) + fib(n-2)
// n:     1,  2,   3,  ,4 ,5 ,6
//fib(n): 1,  1,  ,2,  ,3 ,5 ,8


fun main() {
    println(fib(5))
    println(fib(50, HashMap()))


    println(fibonacci(5))
    println(fibonacci(50))
}

//normal fib O(n^2) time O(N) space
fun fib(n: Int): Long {
    if (n <= 2) return 1
    return fib(n - 1) + fib(n - 2)
}

// fibonacci with dynamic programming O(N) time O(N) space memoization
fun fib(n: Int, knowledge: HashMap<Int, Long>): Long {
    // we check previously calculated fib
    if (n in knowledge) return knowledge[n]!!
    if (n <= 2) return 1
    val fib = fib(n - 1, knowledge) + fib(n - 2, knowledge)
    knowledge[n] = fib
    return fib
}

//tabulation
fun fibonacci(n: Int): Long {
    val array = Array(n + 1) { 0L }
    array[1] = 1
    for (index in 0..array.size - 2) {
        array[index + 1] += array[index]
        if (index + 2 < array.size) {
            array[index + 2] += array[index]
        }
    }
    return array.last()
}




