package decorator.coffee

import decorator.Beverage

class HouseBlend: Beverage{
    override val description: String = "HouseBlend Coffee"

    constructor(): super()

    override fun cost(): Double {
        return 0.89
    }

}