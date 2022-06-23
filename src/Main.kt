import java.util.*

fun main(args: Array<String>) {


    fun isPalindrome(x: Int): Boolean {
        if (x < 0) {
            return false
        }
        var currunt = x
        val stack = Stack<Byte>()
        val queue = LinkedList<Byte>()
        while (currunt != 0) {
            val digit = currunt % 10
            stack.push(digit.toByte())
            queue.add(digit.toByte())
            currunt /= 10
            println(digit)
        }

        while (stack.size > 0) {
            if (stack.pop() != queue.pop()) {
                return false
            }
        }

        return true

    }

    print(isPalindrome(121))
}