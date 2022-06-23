package kotlinPlayground
//In Kotlin, a field is only used as a part of a property to hold its value in memory.
fun main() {
    Dummy().counter = 5
}

class Dummy{
     var counter:Int = 0
        set(value) {
        field = value+1
    }
}