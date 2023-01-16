package com.example.factory.actions.impl

import com.example.factory.actions.Cut

class DiagonalCut: Cut {
    override fun applyCut() {
        println("Cutting the pizza into diagonal slices")
    }

}