package com.example.factory.pizza.impl

import com.example.factory.actions.PizzaActionsFactory
import com.example.factory.ingredients.*
import com.example.factory.pizza.Pizza

class PepperoniPizza(private val pizzaIngredientFactory: PizzaIngredientFactory, private val pizzaActionsFactory: PizzaActionsFactory): Pizza() {
    override var name: String = "PepperoniPizza"

    override fun prepare() {
        println("Preparing $name")
        dough = pizzaIngredientFactory.createDough()
        sauce = pizzaIngredientFactory.createSauce()
        cheese = pizzaIngredientFactory.createCheese()
        pepperoni = pizzaIngredientFactory.createPepperoni()
    }

    override fun cut() {
        pizzaActionsFactory.getCutAction()
    }
}