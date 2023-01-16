package com.example.decorator.coffee

import com.example.decorator.Beverage

class Espresso(override val description: String = "Espresso"): Beverage() {
    override fun cost(): Double {
        return 1.99
    }
}