package com.example.mvc.model.api

interface BeatModelInterface {

    fun initialize(): Unit

    fun on(): Unit

    fun off(): Unit

    fun setBPM(bpm: Long): Unit

    fun getBPM(): Long

    fun registerObserver(o: BeatObserver): Unit

    fun removeObserver(o: BeatObserver): Unit

    fun registerObserver(o: BPMObserver): Unit

    fun removeObserver(o: BPMObserver): Unit

}