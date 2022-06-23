package sorting


fun main(args: Array<String>) {
    val input = arrayOf(3, 4,-1, 7, 0, 100, 1, 2, 5)
    println(bubbleSort(input).contentToString())

}

/*How is it work
 loop n-1 times
   loop n-1 - x=1 x++\
   swap element with what satisfy the condition more

 */
fun bubbleSort(input: Array<Int>): Array<Int> {
    for (i in input.size-2 downTo 0) {
        for (j in 0..i) {
            if (input[j] > input[j + 1]) {
                //swap
                val packet = input[j]
                input[j] = input[j + 1]
                input[j + 1] = packet
            }
        }
    }
    return input
}


fun bubbleSort2(input: Array<Int>): Array<Int> {
    val sorted  =input.clone()
    for(i in sorted.size-1 downTo 1){
        for(j in 0 until i){
            if(sorted[j]>sorted[j+1]){
                val temp =  sorted[j]
                sorted[j] = sorted[j+1]
                sorted[j+1]= temp
            }
        }
    }
    return sorted
}