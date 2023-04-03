package com.example.mvc.view.impl

import com.example.mvc.controller.api.BeatControllerInterface
import com.example.mvc.model.api.BPMObserver
import com.example.mvc.model.api.BeatModelInterface
import com.example.mvc.model.api.BeatObserver
import java.awt.Dimension
import java.awt.GridLayout
import java.awt.*
import java.awt.event.*
import javax.swing.*
import kotlin.system.exitProcess

class DJView(controller: BeatControllerInterface, model: BeatModelInterface) : ActionListener, BPMObserver, BeatObserver {
    private var model: BeatModelInterface? = model
    private var controller: BeatControllerInterface? = controller
    private var viewFrame: JFrame? = null
    private var viewPanel: JPanel? = null
    private var beatBar: BeatBar? = null
    private var bpmOutputLabel: JLabel? = null
    private var bpmLabel: JLabel? = null
    private var bpmTextField: JTextField? = null
    private var setBPMButton: JButton? = null
    private var increaseBPMButton: JButton? = null
    private var decreaseBPMButton: JButton? = null
    private var menuBar: JMenuBar? = null
    private var menu: JMenu? = null
    private var startMenuItem: JMenuItem? = null
    private var stopMenuItem: JMenuItem? = null

    init {
        model.registerObserver(this as BPMObserver)
        model.registerObserver(this as BeatObserver)
    }

    override fun actionPerformed(p0: ActionEvent?) {
        when(p0?.source) {
            setBPMButton -> {
                val bpm = bpmTextField?.text?.toLong()
                if (bpm != null) {
                    controller?.setBPM(bpm)
                }
            }
            increaseBPMButton -> {
                controller?.increaseBPM()
            }
            decreaseBPMButton -> {
                controller?.decreaseBPM()
            }
        }
    }

    override fun updateBPM() {
        val bpm = model?.getBPM()
        if (bpm == 0L) {
            bpmOutputLabel?.text = "offline"
        } else {
            bpmOutputLabel?.text = "Current BPM: $bpm"
        }
    }

    override fun updateBeat() {
        beatBar?.value = 100
    }

    fun createControls() {
        // Create all Swing components here
        JFrame.setDefaultLookAndFeelDecorated(true)
        val controlFrame = JFrame("Control")
        controlFrame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        controlFrame.size = Dimension(100, 80)

        val controlPanel = JPanel(GridLayout(1, 2))

        menuBar = JMenuBar()
        menu = JMenu("DJ Control")
        startMenuItem = JMenuItem("Start")
        menu?.add(startMenuItem)
        startMenuItem?.addActionListener { controller?.start() }
        stopMenuItem = JMenuItem("Stop")
        menu?.add(stopMenuItem)
        stopMenuItem?.addActionListener { controller?.stop() }
        val exit = JMenuItem("Quit")
        exit.addActionListener { exitProcess(0) }
        menu?.add(exit)
        menuBar?.add(menu)
        controlFrame.jMenuBar = menuBar

        bpmTextField = JTextField(2)
        bpmLabel = JLabel("Enter BPM:", SwingConstants.RIGHT)
        setBPMButton = JButton("Set")
        setBPMButton?.size = Dimension(10, 40)
        increaseBPMButton = JButton(">>")
        decreaseBPMButton = JButton("<<")
        setBPMButton?.addActionListener(this)
        increaseBPMButton?.addActionListener(this)
        decreaseBPMButton?.addActionListener(this)

        val buttonPanel = JPanel(GridLayout(1, 2))
        buttonPanel.add(decreaseBPMButton)
        buttonPanel.add(increaseBPMButton)

        val enterPanel = JPanel(GridLayout(1, 2))
        enterPanel.add(bpmLabel)
        enterPanel.add(bpmTextField)
        val insideControlPanel = JPanel(GridLayout(1, 2))
        insideControlPanel.add(enterPanel)
        insideControlPanel.add(setBPMButton)
        insideControlPanel.add(buttonPanel)
        controlPanel.add(insideControlPanel)

        bpmLabel?.border = BorderFactory.createEmptyBorder(5,5,5,5)
        bpmOutputLabel?.border = BorderFactory.createEmptyBorder(5,5,5,5)

        controlFrame.rootPane.defaultButton = setBPMButton
        controlFrame.contentPane.add(controlPanel, BorderLayout.CENTER)

        controlFrame.pack()
        controlFrame.isVisible = true
    }

    fun createView() {
        viewPanel = JPanel(GridLayout(1, 2))
        viewFrame = JFrame("View")
        viewFrame?.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        viewFrame?.size = Dimension(100, 80)
        bpmOutputLabel = JLabel("offline", SwingConstants.CENTER)
        beatBar = BeatBar()
        beatBar?.value = 0
        val bpmPanel = JPanel(GridLayout(2,1))
        bpmPanel.add(beatBar)
        bpmPanel.add(bpmOutputLabel)
        viewPanel?.add(bpmPanel)
        viewPanel?.let { viewFrame?.contentPane?.add(it, BorderLayout.CENTER) }
        viewFrame?.pack()
        viewFrame?.isVisible = true
    }

    fun enableStopMenuItem(): Unit {
        stopMenuItem?.isEnabled = true
    }

    fun disableStopMenuItem(): Unit {
        stopMenuItem?.isEnabled = false
    }

    fun enableStartMenuItem(): Unit {
        startMenuItem?.isEnabled = true
    }

    fun disableStartMenuItem(): Unit {
        startMenuItem?.isEnabled = false
    }
}