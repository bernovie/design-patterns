package com.example.decorator

import com.example.decorator.coffee.DarkRoast
import com.example.decorator.coffee.Espresso
import com.example.decorator.coffee.HouseBlend
import com.example.decorator.condiments.Mocha
import com.example.decorator.condiments.Soy
import com.example.decorator.condiments.Whip

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

