package decorator.coffee

import decorator.Beverage

class DarkRoast(override val description: String = "DarkRoast Coffee"): Beverage() {

    override fun cost(): Double {
        return 0.99
    }
}