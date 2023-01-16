package com.example.factory.pizza.impl

import com.example.factory.actions.PizzaActionsFactory
import com.example.factory.ingredients.*
import com.example.factory.pizza.Pizza

class ClamPizza(private val pizzaIngredientFactory: PizzaIngredientFactory, private val pizzaActionsFactory: PizzaActionsFactory): Pizza() {
    override var name: String = "ClamPizza"

    override fun prepare() {
        println("Preparing $name")
        dough = pizzaIngredientFactory.createDough()
        sauce = pizzaIngredientFactory.createSauce()
        cheese = pizzaIngredientFactory.createCheese()
        clams = pizzaIngredientFactory.createClam()
    }

    override fun cut() {
        pizzaActionsFactory.getCutAction().applyCut()
    }
}