/*
 * TicTacToe class
Jerome Reduta

To do:
1) Have constructor make array rep of board
	0 = space not taken
	1 = space taken by P1
	2 = space taken by P2

2) Have method for player move, asking for player # and position on board
3) Method checking if spot is not taken
4) Method checking if player has won
5) Method that checks if game is tie (might be same as checking for win)
6) toString()
 */

import java.util.*;
public class TicTacToe

	//INSTANCE DATA
{
	// P1 uses "X", P2 uses "O", blank otherwise (when space not claimed)
	private static String[] symbols = new String[] {" ", "X", "O"};

	// Top row
	private int upperLeft = 0;
	private int upperMiddle = 0;
	private int upperRight = 0;

	// Middle row
	private int middleLeft = 0;
	private int center = 0;
	private int middleRight = 0;

	// Bottom row
	private int lowerLeft = 0;
	private int lowerMiddle = 0;
	private int lowerRight = 0;

	// Scanner
	private Scanner scan = new Scanner(System.in);

	// Turn counter
	private int turnNum = 1;

	// Board
	private int[][] board;



	//CONSTRUCTOR
	public TicTacToe()
	{

		// Fills board w/ each value from each row
		board = new int[][] {{upperLeft, upperMiddle, upperRight},
				{middleLeft, center, middleRight},
				{lowerLeft, lowerMiddle, lowerRight}};
	}

	//METHODS

	// Marks an inputted row and column with the player's symbol
	// P1 = "X", P2 = "O";
	public void changeBoard(int pNum) {

			int rowNum;
			int colNum;

			// Loops until valid #s given and space is unclaimed
			boolean loop = true;

			while (loop) {
				System.out.println("\n\nPick an empty spot: ");

				System.out.println("Enter row #: ");
				rowNum = scan.nextInt()-1;

				System.out.println("Enter column #: ");
				colNum = scan.nextInt()-1;

				// For some reason, game breaks if you input rowNum = 4, colNum = 4
				// This does not work with higher #s, or if only one num is 4
				if (rowNum >= 0 && rowNum <= 2 && colNum >= 0 && colNum <= 2 && board[rowNum][colNum] == 0) {
						
					board[rowNum][colNum] = pNum;				
					turnNum++;
					loop = false;
				}
		}	
	}

	// Checks if game is over
	public int checkForEnd(int pNum) {

		// Case: Three in row, horizontal
		for (int index = 0; index < 3; index ++) {
			if (board[index][0] == pNum && board[index][1] == pNum && board[index][2] == pNum) {
				System.out.println("Yea");
				return pNum;
			}
		}

		// Case: Three in row, vertical
		for (int index = 0; index < 3; index ++) {
			if (board[0][index] == pNum && board[1][index] == pNum && board[2][index] == pNum) {
				return pNum;
			}
		}

		// Case: Three in row, diagonal
		for (int index = 0; index <= 2; index += 2) {
			if (board[0][index] == pNum && board[1][1] == pNum && board[2][2-index] == pNum) {
				return pNum;
			}
		}

		// Case: Tie (Board is full, no winner)
		if (turnNum == 10) {
			return -1;
		}

		// Case: Unclaimed spaces left, no winner (game continues)
		return 0;
	}

	public String endMessage(Player[] players, int endNum) {
		if (endNum > 0) {
			players[endNum-1].win();
			players[2-endNum].lose();

			return players[endNum-1].getName() + " wins!";

		}
		
		else {
			players[0].tie();
			players[1].tie();
			return "Tie!";
		}
	}

	// Getters and Setters

	/* Changeable:
		N/A
	*/

	public int getTurnNum() {
		return turnNum;
	}

	public int[][] getBoard() {
		return board;
	}

	// Changes #s to symbols of corresponding user, returns a TicTacToe board
	public String toString()
	{
	   String output = "\n-------------\n";

		for (int index = 0; index < board.length; index++) {
			output += "| ";

			for (int i = 0; i < board[index].length; i++) {
				output += symbols[board[index][i]] + " | ";
			}
			output += "\n-------------\n";
		}
		return output;
	}

	
	// Demo
	/*public static void main(String[] args)
	{

		Scanner scan = new Scanner(System.in);
		TicTacToe a = new TicTacToe();

		int b = a.checkForEnd(2);

		while (b == 0) {


			

			System.out.println("Player #");
			int pNum = scan.nextInt();
			System.out.println("Row #");
			int num1 = scan.nextInt();
			System.out.println("Col #");
			int num2 = scan.nextInt();
			
	
			a.changeBoard(pNum, num1, num2);
			b = a.checkForEnd(pNum);
			System.out.println(a);

		}
		if (b > 0) {
			System.out.println("Player " + b + " wins!");
		}

		else {
			System.out.println("Tie!");
		}

	} */
}
