# Game of life

## Description

The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton 
Conway in 1970. It is a zero-player game, meaning that its evolution is determined by its initial state, requiring no 
further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves. 
It is Turing complete and can simulate a universal constructor or any other Turing machine. 

## Rules

1. Any live cell with fewer than two live neighbours dies, as if by underpopulation.
2. Any live cell with two or three live neighbours lives on to the next generation.
3. Any live cell with more than three live neighbours dies, as if by overpopulation.
4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

## How to install

1. [Install Scala and sbt](https://www.scala-lang.org/download/) 
    
    It's recomended to use Coursier for instlation
    If you can't follow the hyperlink in header:
    https://www.scala-lang.org/download/
    
2. Clone project and move to directory with project
    ```bash
        git clone https://github.com/newbeepi/GameOfLife.git
   
        cd GameOfLife
    ```

3. Compile main sources and run program
    
    Don't worry about versions, if you don't have needed sbt will install it for you 
    ```bash
        sbt compile
   
        sbt run
    ```
    if you followed this guid you should see cells and some buttons

## How to use
    
   While not running you may draw by yourself elsewhere you may only use buttons

| Button  | Function |
| ------------- | ------------- |
| Blinker  | Generates a blinker pattern for game |
| Type 2  | ToDo |
| Random | Randomly fills all cells |
| Step | Make one step |
| Run | Start program that makes one step every 0.5 seconds (you may change it in GameOfLife.scala at 52 line |
| Stop | Pause program |
| Reset | Clear's all cells |

## How it works?

Beacon(period 2) pattern
![](https://github.com/newbeepi/GameOfLife/blob/main/gameoflife2.gif)

Randomly filled
![](https://github.com/newbeepi/GameOfLife/blob/main/gameoflife1.gif)
