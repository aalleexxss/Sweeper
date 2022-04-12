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

## UML

<p align="center">
  <img src="https://github.com/aalleexxss/Sweeper/blob/main/images/sweeperUML.png?raw=true"/>
</p>

This program has two class, ````StartGame```` and ````cell````. The cell class contains the data and methods needed
for the cells of the board. StartGame stores the board and updates the state of the game based on player input.

## How It Works

**Setting up the game -** In order to set up the game, we first get player input for the length and height of the board
as well as the number of mines on the board. From here, an instance of StartGame is created. StartGame
takes the height, width, and number of mines and creates a 2D array of cells. Initially, all cells are
empty and all have the number zero. Mines are then randomly placed one by one. Each time a mine is placed, the cells 
adjacent to it all get increased by 1. The game is now set up and the player can start playing.

**Getting moves from the player -** At each step in the game a player can mark a cell, unmark a cell, or select a cell to 
be uncovered. If a cell is selected to be uncovered, the cell is checked. If the cell is a mine the game ends and the 
player loses. If the cell is not a mine, depth first search is used to uncover additional cells. If a cell is marked,
the program first checks if the cell is a mine. If the cell is a mine, a counter that keeps track of correctly marked
mines is incremented by 1. Each time a mine is marked, the number of marked mines is compared to the total number of 
mines on the board. Unmarking a cell works very similar to marking a cell, however the number of marked mines is 
decremented by 1 if the unmarked cell contains a mine.

**Conditions for the game ending -** This game can end in two different ways. A player selecting a cell that contains a 
mine results in the player losing. This is checked everytime a cell is selected. The game can also end with the player 
winning if all mines are marked. This is checked by keeping track of how many mines the player has correctly marked, 
and comparing that to the total number of mines on the board.
