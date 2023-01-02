# Game of life

## Description

## Rules

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
