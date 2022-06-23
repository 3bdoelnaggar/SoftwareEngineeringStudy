package kotlinPlayground

fun main(){
    val list  = listOf("12346","66663543")
    list.flatMap { string ->
        string.toList()
    }
    print(list)
}