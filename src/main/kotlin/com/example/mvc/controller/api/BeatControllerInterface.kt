package com.example.mvc.controller.api

interface BeatControllerInterface {
    fun start(): Unit
    fun stop(): Unit
    fun increaseBPM(): Unit
    fun decreaseBPM(): Unit
    fun setBPM(bpm: Long): Unit
}