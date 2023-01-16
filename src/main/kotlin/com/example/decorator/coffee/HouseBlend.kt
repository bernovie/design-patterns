package com.example.decorator.coffee

import com.example.decorator.Beverage

class HouseBlend: Beverage {
    override val description: String = "HouseBlend Coffee"

    constructor(): super()

    override fun cost(): Double {
        return 0.89
    }

}