package algorithms.dynamicProgramming

// fib(n) = fib(n-1) + fib(n-2)
// n:     1,  2,   3,  ,4 ,5 ,6
//fib(n): 1,  1,  ,2,  ,3 ,5 ,8


fun main() {
    println(fib(5))
    println(fib(50, HashMap()))
}

//normal fib O(n^2) time O(N) space
fun fib(n: Int): Long {
    if (n <= 2) return 1
    return fib(n - 1) + fib(n - 2)
}

// fibonacci with dynamic programming O(N) time O(N) space
fun fib(n: Int, knowledge: HashMap<Int, Long>): Long {
    // we check previously calculated fib
    if (knowledge.containsKey(n)) {
        return knowledge[n]!!
    }
    if (n <= 2) return 1
    val fib = fib(n - 1, knowledge) + fib(n - 2, knowledge)
    knowledge[n] = fib
    return fib
}


