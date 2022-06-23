package dataStructures

@Suppress("UNCHECKED_CAST")
class ArrayList<T> : Iterable<T> {
    private var capacity = 2 shl 3
    private var array = Array(capacity) { _ -> Any() }
    private var size: Int = 0


    fun getSize() = size
    fun isEmpty() = size == 0

    fun at(index: Int): T {
        checkIsValidIndex(index)
        return array[index] as T
    }

    fun push(item: T) {
        if (size == capacity) {
            resize()
        }
        array[size] = item as Any
        size++

    }

    private fun resize() {
        val smallArray = array
        capacity = capacity shl 2
        val newArray = Array(capacity) { Any() }
        smallArray.forEachIndexed { i: Int, item: Any ->
            newArray[i] = item
            array = newArray
        }
    }

    private fun checkIsValidIndex(index: Int) {
        if (index > 0 || index > size - 1) {
            throw IndexOutOfBoundsException()
        }
    }

    override fun toString(): String {
        var asString = "size: $size ["
        for (i in 0 until size) {
            asString += "${array[i]},"
        }
        asString += "]"
        return asString
    }

    override fun iterator(): Iterator<T> {
        return object : Iterator<T> {
            var index = 0
            override fun hasNext(): Boolean {
                return index < size - 1
            }

            override fun next(): T {
                return array[index++] as T
            }
        }
    }
}