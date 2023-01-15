package decorator.condiments

import decorator.Beverage

class Mocha(override val beverage: Beverage): CondimentDecorator() {
    override val description: String
        get() = beverage.description + ", Mocha"

    override fun cost(): Double {
        return beverage.cost() + when(beverage.size) {
            Size.TALL -> 0.15
            Size.GRANDE -> 0.20
            Size.VENTI -> 0.25
        }
    }

}