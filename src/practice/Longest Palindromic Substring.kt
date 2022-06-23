package practice

fun main() {
    print(longestPalindrome("babad"))
}

fun longestPalindrome(s: String): String {
    var longestValid = Pair(0,0)
    var longestVlidLenght  = 0
    val map = HashMap<Char,ArrayList<Int>>()
    s.forEachIndexed{index,char->
        var list =  map[char]
        if(list==null){
            list = ArrayList()
        }
        list.add(index)
        map[char] = list
    }
    println(map.values.toString())

    map.values.forEach{
        for(i in 0 until it.size){
            for(j in i+1 until it.size){
                val isValid = isValidPalindrome(it[i],it[j],s)
                if(isValid){
                    if(it[j]-it[i]>longestVlidLenght){
                        longestVlidLenght = it[j]-it[i]
                        longestValid = Pair(it[i],it[j])
                    }
                }
            }
        }
    }
    println(longestVlidLenght)
    return if(longestVlidLenght==0){
        s[0].toString()
    }else{
        s.substring(longestValid.first,longestValid.second+1)
    }

}

fun isValidPalindrome(start:Int, end :Int, s:String): Boolean {
    var sCursor = start
    var eCursor = end

    while(sCursor<eCursor){
        if(s[sCursor] != s[eCursor]){
            return false
        }else{
            sCursor++
            eCursor--
        }
    }
    return true
}