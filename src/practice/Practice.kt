package practice

import kotlin.text.StringBuilder

fun main() {
    println(reverseString("abcdf"))

    println(blockedWordsToStars("I am abdalla Elnaggar", arrayOf("abdalla")))

    println(howSum(5, arrayOf(2,3,6), hashMapOf()))

}

fun reverseString(input:String): String {
    val result = StringBuilder(input)
    val size = input.length
    for(i in size-1 downTo 0){
        result.append(input[i])
    }
  return  result.substring(size).toString()
}

fun blockedWordsToStars(input:String,blockedWords:Array<String>):String{
    val words = input.split(" ")
    val blocked = blockedWords.toHashSet()
    val result = StringBuilder()
    words.forEach {
        if(it in blocked){
            result.append("*".repeat(it.length))
        }else{
            result.append(it)
        }
        result.append(" ")
    }
    return result.toString().trim()
}


fun howSum(target:Int,numbers:Array<Int>,knowlodge:HashMap<Int,ArrayList<Int>?>): ArrayList<Int>? {
    if(target in knowlodge) return knowlodge[target]
    if (target==0) return arrayListOf()
    if(target<0) return null


    var result: ArrayList<Int>
    numbers.forEach {
       val x = howSum(target-it,numbers,knowlodge)
        if(x!=null){
            result = ArrayList(x)
            result.add(it)
            return result
        }
    }
    return null

}



