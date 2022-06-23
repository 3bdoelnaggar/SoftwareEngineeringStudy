package dataStructures.stack

import java.util.*
import kotlin.collections.ArrayList

class Stack<T> {
    private val stack = ArrayList<T>()


    fun push(item: T) {
        stack.add(item)
    }

    fun pop(): T {
        if (stack.isEmpty()) {
            throw EmptyStackException()
        }
        return stack.removeAt(stack.size - 1)

    }
}