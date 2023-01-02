package com.gamelife

class Cell (var value: Int = 0){
  def die(): Unit = {
    value = 0
  }
  def toLife(): Unit = {
    value = 1
  }
  def isAlive: Boolean = {
    value == 1
  }
  def reverse(): Unit = {
    if (value == 1) value = 0
    else value = 1
  }
}
