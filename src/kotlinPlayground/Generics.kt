package kotlinPlayground

import com.sun.xml.internal.stream.StaxErrorReporter

fun main() {
    var list: Any = listOf<String>("a", "b")
    list = Int
    /*
    Cannot check for instance of erased type: List<Int>
    if(list is List<Int>){
        print("true")
    }*/

//    if (list is List<*>) {
//        print("true")
//    } else {
//        list as List<Int>
//        print("false")
//    }

    val intList = listOf(1, 2)
   println(isA<String>(intList[0]))

    val listof = listOf("one",2,"three")
    println(listof.filterIsInstance<String>())

}


/*fun <T> isA(value:Any) = value is T */

inline fun <reified T> isA(value: Any) = value is T