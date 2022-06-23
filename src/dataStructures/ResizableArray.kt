package dataStructures

import java.lang.Exception
import java.lang.IndexOutOfBoundsException

class ResizableArray {
    private var array = IntArray(16)
    private var capacity = 16
    private var size = 0
    fun push(input: Int) {
        if (size == capacity) {
           resize(capacity*2)
            array[size] = input

        } else {
            array[size] = input
        }
        size++


    }

    fun isEmpty() = size == 0

    fun at(index: Int): Int {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException()
        } else {
            return array[index]
        }
    }

    fun getSize() = size

    fun insert(index: Int, item: Int) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException()
        } else {
            if (index == size) {
                push(index)
            } else {
                size++
                if (size >= capacity) {
                    capacity *= 2
                }
                val newArray = IntArray(capacity)
                for (i in 0 until index) {
                    newArray[i] = array[i]
                }
                newArray[index] = item

                for (i in index until size - 1) {
                    newArray[i + 1] = array[i]
                }
                array = newArray
            }

        }
    }

    override fun toString(): String {
        return "ResizableArray(array=${array.contentToString()},  size=$size)"
    }

    fun prepend(item: Int) {
        size++
        if (size >= capacity) {
            capacity *= 2
        }
        val newArray = IntArray(capacity)
        newArray[0] = item
        for (i in 1 until size) {
            newArray[i] = array[i - 1]
        }
        array = newArray

    }

    fun pop(): Int {
        if(size==0){
            throw Exception("Array is empty")
        }
        val lastItem = array[size - 1]
        array[size - 1] = 0
        size--
        if(size==capacity/4){
            resize(capacity/2)
        }
        return lastItem
    }

    fun delete(index: Int) {
        if (index < 0 || index > size) {
            throw IndexOutOfBoundsException()
        } else {
            size--
            val newArray = IntArray(capacity)
            for (i in 0 until index) {
                newArray[i] = array[i]
            }

            for (i in index until size) {
                newArray[i] = array[i + 1]
            }
            array = newArray
        }

    }

    fun remove(item: Int) {
        for (i in 0 until size) {
            if (array[i] == item) {
                delete(i)
            }
        }
    }

    fun find(item: Int): Int {
        for (i in 0 until size) {
            if (array[i] == item) {
                return i
            }
        }
        return -1
    }


    private fun resize(capacity:Int){
        this.capacity=capacity
        val newArray = IntArray(capacity)

        for(i in 0 until size){
            newArray[i] = array[i]

        }
        array = newArray
    }




}