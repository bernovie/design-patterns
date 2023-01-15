package decorator

abstract class Beverage {
    open val description: String = "Unknown Beverage"
    open var size: Size = Size.TALL

    abstract fun cost(): Double

    enum class Size {
        TALL,
        GRANDE,
        VENTI
    }
}