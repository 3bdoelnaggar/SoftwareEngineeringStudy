package dataStructures

interface ILinkedList {
    fun getSize(): Int
    fun empty(): Boolean
    fun valueAt(index: Int): Int
    fun pushFront(value: Int)
    fun popFront(): Int
    fun pushBack(value: Int)
    fun popBack(): Int
    fun front(): Int
    fun back(): Int
    fun insertAt(index: Int, value: Int)
    fun erase(index: Int)
    fun value_n_from_end(index: Int): Int
    fun remove(value: Int)
    fun reverse()
}