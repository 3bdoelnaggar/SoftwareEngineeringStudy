fun arrayRunner() {
arrayManipulation(10, arrayOf(arrayOf(1,5,3), arrayOf(4,8,7), arrayOf(6,9,1)))
}

fun arrayManipulation(n: Int, queries: Array<Array<Int>>): Long {
    val current=Array(n){0L}
    var biggerNumber=0L

    queries.forEach{
        for(i in (it[0]-1) until it[1]){
            current[i]+=it[2].toLong()
            if(current[i]>biggerNumber){
                biggerNumber= current[i]
            }
        }
    }
    return biggerNumber

}


fun minimumSwap() {
    val input = arrayOf(1, 3, 5, 2, 4, 6, 7)
    val current = input
    var numberOfSwaps = 0

    var startIndex = 0
    while (startIndex < input.size) {
        val supposedTobe = startIndex + 1
        val currentItem = current[startIndex]
        if (currentItem != supposedTobe) {
            if (current[currentItem - 1] == supposedTobe) {
                current.swap(startIndex, currentItem-1)
                numberOfSwaps++
            } else {
                //find the supposed to be position here and swap with it
                val index = current.find(startIndex+1,supposedTobe)
                current.swap(index, startIndex)
                numberOfSwaps++

            }


        }
        startIndex++

    }
    println(numberOfSwaps)


}

private fun Array<Int>.swap(firstIndex: Int, secondIndex: Int) {
    val temp = this[firstIndex]
    this[firstIndex] = this[secondIndex]
    this[secondIndex] = temp

}

private fun Array<Int>.find(startFrom:Int,number: Int): Int {

    for(i in startFrom..this.size){
        if (this[i] == number) {
            return i
        }
    }
    throw Exception()

}


private fun solveChaoticQueue() {

    /*
    steps
    1-current queue state at first it normal queue 1 ++++++++++ length
    2- final queue state
    3- check every position on current with final if there is change
    here come the logic
    find original position by checking index +1 and index +2 if you didnt find it is Two chaotic
    if find it calculate swapping by  original index - current index
    do this swapping current queue start from last index you were at and do the same again until the array finished
    */
    val finalQueue = arrayOf(1, 2, 5, 3, 7, 8, 6, 4)
    val currentQueue = Array(finalQueue.size) { it + 1 }
    var numberOfBribes = 0

    var startIndex = 0

    while (startIndex < finalQueue.size) {
        if (currentQueue[startIndex] != finalQueue[startIndex]) {
            //check next two indexes
            if (finalQueue[startIndex] == currentQueue[startIndex + 1]) {
                currentQueue.bubbleBy(1, startIndex + 1)
                numberOfBribes += 1
                continue
            }
            if (finalQueue[startIndex] == currentQueue[startIndex + 2]) {
                currentQueue.bubbleBy(2, startIndex + 2)
                numberOfBribes += 2
                continue
            }
            println("Too chaotic")
            return
        }
        startIndex++
    }

    println(numberOfBribes)
}

private fun Array<Int>.bubbleBy(times: Int, index: Int) {
    val temp = this[index]
    repeat(times) {
        this[index - it] = this[index - it - 1]
        this[index - it - 1] = temp
    }

}
