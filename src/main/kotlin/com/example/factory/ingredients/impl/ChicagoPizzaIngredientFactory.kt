package com.example.factory.ingredients.impl

import com.example.factory.ingredients.*

class ChicagoPizzaIngredientFactory: PizzaIngredientFactory {
    override fun createDough(): Dough {
        return ThickCrustDough()
    }

    override fun createSauce(): Sauce {
        return PlumTomatoSauce()
    }

    override fun createCheese(): Cheese {
        return MozarellaCheese()
    }

    override fun createVeggies(): Array<Veggies> {
        return arrayOf(Spinach(), BlackOlive())
    }

    override fun createPepperoni(): Pepperoni {
        return SlicedPepperoni()
    }

    override fun createClam(): Clams {
        return FrozenClams()
    }
}