package practice

/*
problems
1-https://www.hackerrank.com/challenges/halloween-sale/problem
2-https://www.hackerrank.com/challenges/organizing-containers-of-balls
 */
fun main(args: Array<String>) {
    val result = organizingContainers(arrayOf(arrayOf(0, 1), arrayOf(1, 1)))
    println(result)

}

fun organizingContainers(container: Array<Array<Int>>): String {
    //first container
    if (container[0][0] - container[1][1] == 0 || container[0][1] - container[1][0] == 0) {
        return "Possible"
    }

    return "Impossible"

}





