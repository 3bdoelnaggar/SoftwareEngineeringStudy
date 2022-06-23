package practice

fun weightedUniformStrings(s: String, queries: Array<Int>): Array<String> {
    val aAsci = 'a'.toInt()
    val map = HashMap<Long,Long>()
    s.forEach {
        val num = it.toInt()-aAsci+1
        map[num.toLong()] = map[num.toLong()]?.plus(1) ?:1
    }
    val result = Array(queries.size){"No"}
    queries.forEachIndexed{index, i ->
        for((key,value) in map){
            if(key ==i.toLong()){
                result[index] = "Yes"
                break
            }
            if(key==1L){
                continue
            }
            for(x in  2..value){
                if(key*x==i.toLong()){
                    result [index]="Yes"
                    break
                }
            }
        }
    }
    return result
}