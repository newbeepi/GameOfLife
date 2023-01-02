package com.gamelife

import java.util.concurrent.TimeUnit

import javafx.animation.AnimationTimer
import scalafx.Includes._
import scalafx.application.JFXApp3
import scalafx.scene.Scene
import scalafx.scene.canvas.Canvas
import scalafx.scene.control.Button
import scalafx.scene.input.MouseEvent
import scalafx.scene.layout.{HBox, VBox}

object GameOfLife extends JFXApp3 {
  override def start(): Unit = {
    val width = 500
    val height = 500
    val cellSize = 10

    val root = new VBox(10)
    val scene1 = new Scene(root, width, height+100)
    val canvas = new Canvas(width, height);

    val random = new Button("Random");
    val step = new Button("Step");
    val run = new Button("Run");
    val stop = new Button("Stop");
    val reset = new Button("Reset")


    val blinker = new Button("Blinker")
    val type2 = new Button("Type 2")

    root.getChildren.addAll(canvas, new HBox(10, blinker, type2, random, step, run, stop, reset));

    stage = new JFXApp3.PrimaryStage {
      title = "Game of life"
      scene = scene1
    }

    val rows = Math.floor(height / cellSize).toInt
    val columns = Math.floor(width / cellSize).toInt

    val graphics = canvas.getGraphicsContext2D
    val life = new Life(rows = rows, cols = columns, cellSize = cellSize, width = width, height = height, graphics = graphics)
    life.init();

    val runAnimation: AnimationTimer = new AnimationTimer() {
      private var lastUpdate: Long = 0;

      override def handle(now: Long): Unit =
        if ((now - lastUpdate) >= TimeUnit.MILLISECONDS.toNanos(500)){
          life.tick();
          lastUpdate = now
        }
    }
    var isRunning = false
    canvas.handleEvent(MouseEvent.MouseClicked){ (me: MouseEvent) => {
      println("Handled click!")
      if (!isRunning){
        life.reverseCellColor(me.sceneX, me.sceneY)
      }
    }
    }
    blinker.onAction = e => life.blinker()
    random.onAction  = e => life.fillWithRandom()
    run.onAction     = e => {
      runAnimation.start()
      isRunning = true
    }
    step.onAction    = e => life.tick()
    stop.onAction    = e => {
      runAnimation.stop()
      isRunning = false
    }
    reset.onAction   = e => life.init()
  }
}