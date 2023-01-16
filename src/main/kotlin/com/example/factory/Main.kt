package com.example.factory

import com.example.factory.pizza.Pizza

fun main() {
    val nyStore: PizzaStore = NYPizzaStore()
    val chicagoStore: PizzaStore = ChicagoPizzaStore()
    println("========New York Store========")
    var pizza: Pizza = nyStore.orderPizza(Pizza.Type.CHEESE)
    println("Ethan ordered a ${pizza.name}\n")

    println("==========Chicago==========")
    pizza = chicagoStore.orderPizza(Pizza.Type.CHEESE)
    println("Joel ordered a ${pizza.name}\n")
}