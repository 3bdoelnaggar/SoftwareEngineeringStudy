package practice


fun main(){
    println(brutofrce(1000000000))
}


fun brutofrce(n:Int): Int {
    if (n % 2 != 0) return 0
    val setOfEvenDivisors = HashSet<Int>()
    setOfEvenDivisors.add(n)
    var div = n / 2
    while (div > 2) {
        if(n%div==0){
            val  result = n/div
            println("Result:$result")
            if(div%2==0){
                setOfEvenDivisors.add(div)
            }
            if(result%2==0){
                setOfEvenDivisors.add(result)
            }
        }
        if(div%2==0) {
            div -= 2
        }else{
            div++
        }
    }
    return setOfEvenDivisors.size


}

fun divisors(n: Int): Int {
    if (n % 2 != 0) return 0
    val setOfEvenDivisors = HashSet<Int>()
    setOfEvenDivisors.add(n)
    var div = n / 2
    while (div > 2) {
        println(div)
        if(n%div==0){
           val  result = n/div
            println("Result:$result")
            if(div%2==0){
                setOfEvenDivisors.add(div)
                div /= 2
            }else{
                div++
            }
            if(result%2==0){
                setOfEvenDivisors.add(result)
            }
        }else{
            if(div%2==0){
                div /= 2
            }else{
                div++
            }
        }
    }
    print(setOfEvenDivisors.toList().toString())
    return setOfEvenDivisors.size

}