package com.example.mvc.controller.impl

import com.example.mvc.controller.api.BeatControllerInterface
import com.example.mvc.model.api.BeatModelInterface
import com.example.mvc.view.impl.DJView

class BeatControllerImpl(model: BeatModelInterface): BeatControllerInterface {
    private var model: BeatModelInterface
    private var view: DJView

    init {
        this.model = model
        view = DJView(this, model)
        view.createView()
        view.createControls()
        view.disableStopMenuItem()
        view.enableStartMenuItem()
        model.initialize()
    }

    override fun start() {
        model.on()
        view.disableStartMenuItem()
        view.enableStopMenuItem()
    }

    override fun stop() {
        model.off()
        view.disableStopMenuItem()
        view.enableStartMenuItem()
    }

    override fun increaseBPM() {
        val bpm = model.getBPM()
        model.setBPM(bpm + 1)
    }

    override fun decreaseBPM() {
        val bpm = model.getBPM()
        model.setBPM(bpm - 1)
    }

    override fun setBPM(bpm: Long) {
        model.setBPM(bpm)
    }
}