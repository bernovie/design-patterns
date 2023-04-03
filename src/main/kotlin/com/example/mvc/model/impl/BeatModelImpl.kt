package com.example.mvc.model.impl

import com.example.mvc.model.api.BPMObserver
import com.example.mvc.model.api.BeatModelInterface
import com.example.mvc.model.api.BeatObserver
import java.io.File
import java.util.logging.Level
import java.util.logging.Logger
import javax.sound.sampled.AudioSystem
import javax.sound.sampled.Clip
import javax.sound.sampled.Line
import kotlin.Exception

class BeatModelImpl: BeatModelInterface, Runnable {
    private val beatObservers: MutableList<BeatObserver> = ArrayList()
    private val bpmObservers: MutableList<BPMObserver> = ArrayList()
    private val logger: Logger = Logger.getLogger("BeatModel")
    private var bpm: Long = 90
    private var thread: Thread? = null
    private var stop: Boolean = false
    private var clip: Clip? = null

    override fun initialize() {
        try {
            val resource = File("clap.wav")
            clip = AudioSystem.getLine(Line.Info(Clip::class.java)) as Clip
            clip?.open(AudioSystem.getAudioInputStream(resource))
        } catch (e: Exception) {
            logger.log(Level.SEVERE, "Error: couldn't open audio clip", e)
        }
    }

    override fun on() {
        bpm = 90
        notifyBPMObservers()
        thread = Thread(this)
        stop = false
        thread?.start()
    }

    private fun playBeat(): Unit {
        clip?.framePosition = 0
        clip?.start()
    }

    private fun stopBeat(): Unit {
        clip?.framePosition = 0
        clip?.stop()
    }

    override fun off() {
        stopBeat()
        stop = true
    }

    override fun setBPM(bpm: Long) {
        this.bpm = bpm
        notifyBPMObservers()
    }

    override fun getBPM(): Long {
        return bpm
    }

    override fun registerObserver(o: BeatObserver) {
        beatObservers.add(o)
    }

    override fun registerObserver(o: BPMObserver) {
        bpmObservers.add(o)
    }

    override fun removeObserver(o: BeatObserver) {
        beatObservers.remove(o)
    }

    override fun removeObserver(o: BPMObserver) {
        bpmObservers.remove(o)
    }

    override fun run() {
        while(!stop) {
            playBeat()
            notifyBeatObservers()
            try {
                Thread.sleep(60000/getBPM())
            } catch (e: Exception) {
                logger.log(Level.WARNING, "Thread couldn't sleep", e)
            }
        }
    }

    private fun notifyBPMObservers() {
        for (observer in bpmObservers) {
            observer.updateBPM()
        }
    }

    private fun notifyBeatObservers() {
        for (observer in beatObservers) {
            observer.updateBeat()
        }
    }

}