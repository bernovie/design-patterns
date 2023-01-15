package decorator

import decorator.coffee.DarkRoast
import decorator.coffee.Espresso
import decorator.coffee.HouseBlend
import decorator.condiments.Mocha
import decorator.condiments.Soy
import decorator.condiments.Whip

fun main() {
    val beverage: Beverage = Espresso()
    println("${beverage.description} $${beverage.cost()}")

    val beverage2 = Whip(Mocha(Mocha(DarkRoast())))
    beverage2.size = Beverage.Size.GRANDE
    println("${beverage2.description} $${beverage2.cost()}")

    val beverage3 = Whip(Mocha(Soy(HouseBlend())))
    beverage3.size = Beverage.Size.GRANDE
    println("${beverage3.description} $${beverage3.cost()}")
}

