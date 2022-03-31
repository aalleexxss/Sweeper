# Sweeper
This repository contains the code for a text interface version of the classic game minesweeper, written in Java.

## Background Info
Sweeper starts as a rectangular grid of cells. A cell can be visible or covered, and can contain a mine or not.
Each cell that doesnt have a mine, has a number representing the number of mines in adjacent cells. Initially, 
all cells are covered. A player makes cells visible by selecting covered cells. If the player selects a cell with 
a mine in it, the game is over and the player loses. If the player selects a cell without a mine in it, more empty
cells are made visible. Additionally, the player can mark cells that they think contain a mine. If the player 
correctly marks all mines, the game is over and the player wins. A graphic explaining this would look like: