package decorator.condiments

import decorator.Beverage

class Soy(override val beverage: Beverage) : CondimentDecorator() {
    override val description: String
        get() {
            return beverage.description + ", Soy"
        }

    override fun cost(): Double {
        return beverage.cost() + when(beverage.size) {
            Size.TALL -> 0.10
            Size.GRANDE -> 0.15
            Size.VENTI -> 0.20
        }
    }
}