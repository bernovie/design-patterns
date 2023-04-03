package com.example.mvc.view.impl;
  
import javax.swing.*

class BeatBar: JProgressBar(), Runnable {
	private val thread: Thread = Thread(this)

	init {
		maximum = 100
		thread.start()
	}

	override fun run() {
		while(true) {
			var value = value
			value = (value * .75).toInt()
			setValue(value)
			repaint()
			try {
				Thread.sleep(50)
			} catch (e: Exception) {}
		}
	}

	companion object {
		private const val serialVersionUID = 2L
	}
}
