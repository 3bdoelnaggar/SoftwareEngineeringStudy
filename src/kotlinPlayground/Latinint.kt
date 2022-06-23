package kotlinPlayground


data class Person(val name:String)

fun main(){

    Latinint().init().printPerson()

}
class Latinint {


    lateinit var x : Person
    fun init(): Latinint {
        x= Person("Said")
        return this
    }
    fun printPerson(){
        if(::x.isInitialized){
        }
        print(::x.hashCode())

    }
}