package com.example.factory.pizza

import com.example.factory.ingredients.*

abstract class Pizza {
    abstract val name: String

    var dough: Dough? = null
    var sauce: Sauce? = null
    var cheese: Cheese? = null
    var pepperoni: Pepperoni? = null
    var clams: Clams? = null
    var veggies: Array<Veggies>? = null

    abstract fun prepare()

    open fun bake() {
        println("Bake for 25 minutes at 350F")
    }

    abstract fun cut()

    open fun box() {
        println("Place pizza in official PizzaStore box")
    }

    enum class Type {
        CHEESE,
        VEGGIE,
        CLAM,
        PEPPERONI
    }
}