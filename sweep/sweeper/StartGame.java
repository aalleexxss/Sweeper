package sweeper;

import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;


public class StartGame {
	cell[][] board;
	int height;
	int width;
	int bombs;
	int markedBombs;
	int markedCells;

	StartGame(int h, int w, int b) {
		this.board = new cell[h][w];
		this.bombs = b;
		this.width = w;
		this.height = h;
		
		markedBombs = 0;
		markedCells = 0;
		
		for (int i=0; i<h; i++) {
			for (int j=0; j<w; j++) {
				board[i][j] = new cell();
			}
		}
		//board and start variables now set
		
		placeBombs();
		printNumbers();
		
		boolean gameLost = false;
		boolean gameWon = false;
		while (!gameLost && !gameWon) {
			Scanner scan = new Scanner(System.in);
			System.out.print("Enter M to mark a cell, U to unmark a cell, or S to select a cell -> ");
			char playerChoice = scan.next().charAt(0);
			System.out.print("Enter X location: ");
			int xLocation = scan.nextInt();
			System.out.print("Enter Y location: ");
			int yLocation = scan.nextInt();
			
			if (playerChoice == 'M' || playerChoice == 'm') {
				board[xLocation][yLocation].mark();
				markedCells++;
				if (board[xLocation][yLocation].getNum() == -1) {
					markedBombs++;
				}
				if (markedBombs == this.bombs) {
					gameWon = true;
					break;
				}
			} else if (playerChoice == 'U' || playerChoice == 'u') {
				if (board[xLocation][yLocation].marked) {
					board[xLocation][yLocation].unMark();
					markedCells--;
					if(board[xLocation][yLocation].getNum() == -1) {
						markedBombs--;
					}
				}
			} else if (playerChoice == 'S' || playerChoice == 's') {
				if (board[xLocation][yLocation].getNum() == -1) {
					System.out.println("Game Lost!");
					gameLost = true;
					break;
				} else {
					select(xLocation, yLocation);
				}
			}
			printView();
		}
	}
	
	public Queue<int[]> select(int x, int y) {
		Queue<int[]> changedCells = new LinkedList<int[]>();
		
		Queue<int[]> searchQ = new LinkedList<int[]>();
		int[] xAndY = {x, y};
		searchQ.add(xAndY);
		board[x][y].makeVisible();
		
		while (!searchQ.isEmpty()) {
			changedCells.add(searchQ.peek());
			int[] currentXY = searchQ.remove();
			Queue<int[]> adj = getAdjacent(currentXY[0], currentXY[1]);
			
			while (!adj.isEmpty()) {
				if (board[adj.peek()[0]][adj.peek()[1]].getNum() != -1) {
					if (!board[adj.peek()[0]][adj.peek()[1]].visible) {
						board[adj.peek()[0]][adj.peek()[1]].makeVisible();
						if (board[adj.peek()[0]][adj.peek()[1]].getNum() == 0) {
							searchQ.add(adj.remove());
						} else {
							adj.remove();
						}
					} else {
						adj.remove();
					}
				} else {
					adj.remove();
				}
			}
			
		}
		return changedCells;
	}
	
	public void printView() {
		for (int i=0; i<board[0].length; i++) {
			System.out.print("----");
		}
		System.out.println();
		for (int j=0; j<board.length; j++) {
			System.out.print("|");
			for (int k=0; k<board[0].length; k++) {
				if (board[j][k].visible) {
					if (board[j][k].getNum() == 0) {
						System.out.print(" . |");
					} else {
						System.out.print(" " +board[j][k].getNum()+ " |");
					}
				} else {
					if (board[j][k].marked) {
						System.out.print(" M |");
					} else {
						System.out.print(" O |");
					}
				}
			}
			System.out.println();
			for (int i=0; i<board[0].length; i++) {
				System.out.print("----");
			}
			System.out.println();
		}	
	}
	
	public void printNumbers() {
		for (int i=0; i<board[0].length; i++) {
			System.out.print("----");
		}
		System.out.println();
		for (int j=0; j<board.length; j++) {
			System.out.print("|");
			for (int k=0; k<board[0].length; k++) {
				if (board[j][k].getNum()<0) {
					System.out.print(" X |");
				} else {
					System.out.print(" " +board[j][k].getNum()+ " |");
				}
			}
			System.out.println();
			for (int i=0; i<board[0].length; i++) {
				System.out.print("----");
			}
			System.out.println();
		}
	}
	
	//Randomly places mines and adds one to adjacent cells
	public void placeBombs() {
		Random rand = new Random();
		int count = this.bombs;
		while (count > 0) {
			int x = rand.nextInt(height);
			int y = rand.nextInt(width);
			if (board[x][y].getNum() > -1) {
				board[x][y].setNum(-1);
				count--;
				Queue<int[]> adj = getAdjacent(x, y);
				addOne(adj);
			}
		}
	}
	
	public Queue<int[]> getAdjacent(int x, int y) {
		Queue<int[]> adjacent = new LinkedList<int[]>();
		
		for (int i=-1; i<2; i++) {
			for (int j=-1; j<2; j++) {
				int[] temp = {x+i, y+j};
				if (temp[0] >= 0 && temp[0] < this.height) {
					if (temp[1] >= 0 && temp[1] < this.width) {
						if (i!=0 || j!=0) {
							adjacent.add(temp);
						}
					}
				}
			}
		}
		return adjacent;
	}
	
	public void addOne(Queue<int[]> cells) {
		while (!cells.isEmpty()) {
			int[] temp = cells.remove();
			if(board[temp[0]][temp[1]].getNum() >= 0) {
				board[temp[0]][temp[1]].plus1();
			}
		}
	}
	
	
}






























