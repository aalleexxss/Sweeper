package sweeper;

import java.util.Scanner;

public class game {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		/*
		System.out.print("Enter width of board -> ");
		int width = scan.nextInt();

		System.out.print("Enter height of board -> ");
		int height = scan.nextInt();
		
		System.out.print("Enter number of bombs -> ");
		int bombs = scan.nextInt();
		*/
		
		StartGame newGame = new StartGame(7, 11, 6);
		
	}

}
