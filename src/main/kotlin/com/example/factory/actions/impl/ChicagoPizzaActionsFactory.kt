package com.example.factory.actions.impl

import com.example.factory.actions.Cut
import com.example.factory.actions.PizzaActionsFactory

class ChicagoPizzaActionsFactory: PizzaActionsFactory {
    override fun getCutAction(): Cut {
        return SquareCut()
    }
}