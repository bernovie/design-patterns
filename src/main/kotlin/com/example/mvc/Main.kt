package com.example.mvc

import com.example.mvc.controller.impl.BeatControllerImpl
import com.example.mvc.model.api.BeatModelInterface
import com.example.mvc.model.impl.BeatModelImpl

fun main() {
    val model: BeatModelInterface = BeatModelImpl()
    BeatControllerImpl(model)
}