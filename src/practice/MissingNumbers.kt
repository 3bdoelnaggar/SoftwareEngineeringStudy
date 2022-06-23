package practice



fun missingNumbers(arr: Array<Int>, brr: Array<Int>): Array<Int> {
    val set =  HashSet<Int>()
   val map =  arr.groupingBy {
        it
    }.eachCount().toMutableMap()

    brr.forEach {
       val count =  map.getOrDefault(it,0)
        if(count==0){
            set.add(it)
        }else{
            map[it] = count-1
        }
    }
    return set.sorted().toTypedArray()
}