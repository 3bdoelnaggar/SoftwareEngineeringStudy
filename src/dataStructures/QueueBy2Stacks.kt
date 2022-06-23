package dataStructures


import java.util.*

class QueueBy2Stacks {

    private val mainStack: Stack<Int> = Stack()
    private val bucketStack: Stack<Int> = Stack()


    fun enqueue(value: Int) {
        mainStack.push(value)
    }

    fun dequeue(): Int? {
        if(bucketStack.isEmpty()){
            for (index in 0 until mainStack.size) {
                bucketStack.push(mainStack.pop())
            }
        }
       return bucketStack.pop()

    }

    fun printFront() {
        if(bucketStack.isNotEmpty()){
            println(bucketStack.peek())
        }else{
            val dequeue = dequeue()
            println(dequeue)
            bucketStack.push(dequeue)
        }

    }

}