package dataStructures.queue

class Queue <T>{
    private val  queue = ArrayList<T>()


    fun enqueue(item:T){
        queue.add(item)
    }
    fun dequeue():T{
        if(queue.isEmpty()){
            throw Exception("queue is empty")
        }
       return queue.removeAt(0)
    }
}