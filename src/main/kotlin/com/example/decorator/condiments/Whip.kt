package com.example.decorator.condiments

import com.example.decorator.Beverage

class Whip(override val beverage: Beverage) : CondimentDecorator() {
    override val description: String
        get() {
            return beverage.description + ", Whip"
        }

    override fun cost(): Double {
        return beverage.cost() + when(beverage.size) {
            Size.TALL -> 0.05
            Size.GRANDE -> 0.10
            Size.VENTI -> 0.15
        }
    }

}