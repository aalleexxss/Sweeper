# Sweeper
This repository contains the code for a text interface version of the classic game minesweeper, written in Java.

## Background Info
Sweeper starts as a rectangular grid of cells. A cell can be visible or covered, and can contain a mine or not.
Each cell that doesnt have a mine, has a number representing the number of mines in adjacent cells. Initially, 
all cells are covered. A player makes cells visible by selecting covered cells. If the player selects a cell with 
a mine in it, the game is over and the player loses. If the player selects a cell without a mine in it, more empty
cells are made visible. Additionally, the player can mark cells that they think contain a mine. If the player 
correctly marks all mines, the game is over and the player wins. A graphic explaining this would look like:

<p align="center">
  <img src="https://github.com/aalleexxss/Sweeper/blob/main/images/sweeperBackground.png?raw=true"/>
</p>

## Class Descriptions

<p align="center">
  <img src="https://github.com/aalleexxss/Sweeper/blob/main/images/sweeperUML.png?raw=true"/>
</p>

This program has two class, ````StartGame```` and ````cell````.

## How It Works

**Setting up the game -** In order to set up the game, we frist get user input for the length and heigh of the board
as well as the number of mines on the board. From here, and instance of ````StartGame```` is created. ````StartGame````
takes the height, width, and number of mines and creates a height by width array of cells. Initially, all cells are
empty and all have the number zero Becaus no mines have been placed yet. Below is a UML diagram discribing
````StartGame```` and ````cell````.
