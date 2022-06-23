package algorithms

import kotlin.math.max
import kotlin.math.min


/*
* Find the greatest common denominator (GCD) of two integrates
* For two integers a and b, where a > b, divide a by b
* if reminder r is  0  then stop, GCD is b
* else set a to b and b to r and repeat until r is 0 */
fun main() {
    print(gcd2(20,8))
}

fun gcd(num1: Int, num2: Int): Int {
    var a = max(num1,num2)
    var b = min(num1,num2)

    while (true){
        val reminder = a%b
        if(reminder==0){
            return b
        }else{
            a=b
            b=reminder
        }
    }
}

fun gcd2(num1: Int, num2: Int): Int {
    var a = max(num1,num2)
    var b = min(num1,num2)
    while (b!=0){
        val reminder = a%b
            a=b
            b=reminder
    }
    return a
}

