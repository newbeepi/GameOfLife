package com.gamelife

import scala.util.Random
import scalafx.scene.canvas.GraphicsContext
import scalafx.scene.paint.Color

import com.gamelife.Cell


private class Life(var graphics: GraphicsContext) {
  var rows: Int = 0
  var cols: Int = 0
  var width: Int = 0
  var height: Int = 0
  var grid: Array[Array[Cell]] = Array(Array(new Cell(0)))
  val random = new Random()
  var cellSize: Int = 0

  def this(rows: Int, cols: Int, cellSize: Int, height: Int, width: Int, graphics: GraphicsContext) = {
    this(graphics)
    this.rows = rows
    this.cols = cols
    this.grid = Array.ofDim[Cell](rows, cols)
    this.height = height
    this.width = width
    this.cellSize = cellSize
  }

  private def fillZeros(array: Array[Array[Cell]] = grid): Unit = {
    for (i <- 0 until rows; j <- 0 until cols){
      array(i)(j) = new Cell(0)
    }
  }
  def init(): Unit = {
    fillZeros()
    draw()
  }

  def reverseCellColor(x: Double, y: Double): Unit ={
    val row_number = x.toInt / cellSize
    val col_number = y.toInt / cellSize
    grid(row_number)(col_number).reverse()
    draw()
  }
  def fillWithRandom(): Unit = {
    for (i <- 0 until rows; j <- 0 until cols){
      grid(i)(j) = new Cell(random.nextInt(2))
    }
    draw()
  }

  def blinker(): Unit = {
    fillZeros()
    val y_half = (rows / 2)
    val x_half = (cols / 2)
    grid(x_half)(y_half).toLife()
    grid(x_half + 1)(y_half).toLife()
    grid(x_half - 1)(y_half).toLife()

    draw()
  }

  def draw(): Unit = {
    graphics.setFill(Color.Lavender)
    graphics.fillRect(0, 0, width, height)
    for (i <- grid.indices; j <- grid(i).indices){
      if (grid(i)(j).isAlive){
        graphics.setFill(Color.gray(0.5, 0.5))
        graphics.fillRect(i * cellSize, j * cellSize, cellSize, cellSize)
        graphics.setFill(Color.Black)
        graphics.fillRect((i * cellSize) + 1, (j * cellSize) + 1, cellSize - 2, cellSize - 2)
      }
      else{
        graphics.setFill(Color.gray(0.5, 0.5));
        graphics.fillRect(i * cellSize, j * cellSize, cellSize, cellSize);
        graphics.setFill(Color.Lavender);
        graphics.fillRect((i * cellSize) + 1, (j * cellSize) + 1, cellSize - 2, cellSize - 2)
      }
    }
  }
  private def neighboursNum(i: Int, j: Int): Int = {
    var value = 0
    for (x <- i - 1 to i + 1; y <- j - 1 to j + 1){
      if (x < 0 || y < 0){}
      else if (x >= grid.length || y >= grid(0).length) {}
      else {
        if (grid(x)(y).isAlive) value += 1
      }
    }
    value - grid(i)(j).value
  }
  def tick(): Unit = {
    val next: Array[Array[Cell]] = Array.ofDim[Cell](rows, cols)
    fillZeros(next)
    for (i <- 0 until rows; j <- 0 until cols){
      val neighboursCount = neighboursNum(i, j)
      if (neighboursCount < 2 || neighboursCount > 3){
        next(i)(j).die()
      }
      else if (neighboursCount == 3){
        next(i)(j).toLife()
      }
      else {
        next(i)(j) = grid(i)(j)
      }
    }
    grid = next
    draw()
  }
}
