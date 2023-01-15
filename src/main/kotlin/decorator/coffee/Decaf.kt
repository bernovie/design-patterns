package decorator.coffee

import decorator.Beverage

class Decaf: Beverage {
    override val description: String = "Decaf Coffee"

    constructor(): super()

    override fun cost(): Double {
        return 1.05
    }

}