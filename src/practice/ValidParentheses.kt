package practice

import java.util.*


fun main() {
    println(isValid("((((((((()))))))))"))
//    println(isValid("((((())))))"))
//    println(isValid("((((()))))"))
//    println(isValid("()[]{}"))
}

fun isValid(s: String): Boolean {
    val stack = Stack<Char>()
    for (element in s) {
        if(stack.empty()){
            stack.push(element)
            continue
        }
        val c =  stack.peek()
        println("$c $element")
        val closeFor = c.isCloseFor(element)
        if(closeFor){
            stack.pop()
        }else{
            stack.push(element)
        }
    }
    return stack.empty()
}

private fun Char.isCloseFor(c: Char): Boolean {
    if(this=='['&& c ==']') return true
   if (this=='{'&& c =='}') return true
    return this=='('&& c ==')'
}
