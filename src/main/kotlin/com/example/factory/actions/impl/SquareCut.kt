package com.example.factory.actions.impl

import com.example.factory.actions.Cut

class SquareCut: Cut {
    override fun applyCut() {
        println("Cutting the pizza into square slices")
    }

}