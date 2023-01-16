package com.example.factory

import com.example.factory.actions.PizzaActionsFactory
import com.example.factory.actions.impl.ChicagoPizzaActionsFactory
import com.example.factory.ingredients.PizzaIngredientFactory
import com.example.factory.ingredients.impl.ChicagoPizzaIngredientFactory
import com.example.factory.pizza.Pizza
import com.example.factory.pizza.impl.CheesePizza
import com.example.factory.pizza.impl.ClamPizza
import com.example.factory.pizza.impl.PepperoniPizza
import com.example.factory.pizza.impl.VeggiePizza


class ChicagoPizzaStore(): PizzaStore() {
    override fun createPizza(type: Pizza.Type): Pizza {
        val pizzaIngredientFactory: PizzaIngredientFactory = ChicagoPizzaIngredientFactory()
        val pizzaActionsFactory: PizzaActionsFactory = ChicagoPizzaActionsFactory()
        return when(type) {
            Pizza.Type.CHEESE -> CheesePizza(pizzaIngredientFactory, pizzaActionsFactory)
            Pizza.Type.VEGGIE -> VeggiePizza(pizzaIngredientFactory, pizzaActionsFactory)
            Pizza.Type.CLAM -> ClamPizza(pizzaIngredientFactory, pizzaActionsFactory)
            Pizza.Type.PEPPERONI -> PepperoniPizza(pizzaIngredientFactory, pizzaActionsFactory)
        }
    }
}