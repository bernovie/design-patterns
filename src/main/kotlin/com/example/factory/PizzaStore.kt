package com.example.factory

import com.example.factory.pizza.Pizza

abstract class PizzaStore {

    fun orderPizza(type: Pizza.Type): Pizza {
        val pizza = createPizza(type)

        with(pizza) {
            prepare()
            bake()
            cut()
            box()
        }
        return pizza
    }

    protected abstract fun createPizza(type: Pizza.Type): Pizza
}