package com.example.decorator.condiments

import com.example.decorator.Beverage

abstract class CondimentDecorator: Beverage() {
    abstract val beverage: Beverage
    override var size: Size
        get() = beverage.size
        set(value) {beverage.size = value}
}