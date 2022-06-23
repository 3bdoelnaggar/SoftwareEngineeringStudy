package designPatterns.decorator

abstract class Beverage {
    abstract fun cost(): Int
}
class Espresso : Beverage() {
    override fun cost(): Int {
        return 2
    }
}
abstract class AddOnsBeverage : Beverage()

class Caramel(private val beverage: Beverage) : AddOnsBeverage() {
    override fun cost(): Int {
        return beverage.cost() + 6
    }
}

fun main() {
    println(Caramel(Espresso()).cost())
    println(Espresso().cost())
}