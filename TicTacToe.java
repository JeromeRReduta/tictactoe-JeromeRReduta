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
{
	private static String[] symbols = new String[] {" ", "X", "O"};
	private int upperLeft = 0;
	private int upperMiddle = 0;
	private int upperRight = 0;

	private int middleLeft = 0;
	private int center = 0;
	private int middleRight = 0;

	private int lowerLeft = 0;
	private int lowerMiddle = 0;
	private int lowerRight = 0;

	private Scanner scanner = new Scanner(System.in);

	private int turnNum = 1;

	private int[][] board;

	//INSTANCE DATA

	//CONSTRUCTOR
	public TicTacToe()
	{
		board = new int[][] {{upperLeft, upperMiddle, upperRight},
				{middleLeft, center, middleRight},
				{lowerLeft, lowerMiddle, lowerRight}};

	}

	//METHODS

	// Given p#, row#, and col#, changes board state to match (Note: looping will be done in driver)
	public void changeBoard(int pNum, int rowNum, int colNum) {

	

		if (board[rowNum][colNum] == 0) {
				
			board[rowNum][colNum] = pNum;				
			turnNum++;
		}
		
		else {
			System.out.println("Choose an empty spot!");
}

	
}

	public int checkForEnd(int pNum) {
		for (int index = 0; index < 3; index ++) {
			if (board[index][0] == pNum && board[index][1] == pNum && board[index][2] == pNum) {
				System.out.println("Yea");
				return pNum;
			}
		}

		for (int index = 0; index < 3; index ++) {
			if (board[0][index] == pNum && board[1][index] == pNum && board[2][index] == pNum) {
				return pNum;
			}
		}

		for (int index = 0; index <= 2; index += 2) {
			if (board[0][index] == pNum && board[1][1] == pNum && board[2][2-index] == pNum) {
				return pNum;
			}
		}

		if (turnNum == 10) {
			return -1;
		}

		return 0;
	}

	public int getTurnNum() {
		return turnNum;
	}

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

	public String endMessage(Player[] players, int endNum) {
		if (endNum > 0) {
			players[endNum-1].win();
			players[2-endNum].lose();

			return players[endNum-1].getName() + " wins!";

		}
		
		else {
			players[endNum-1].tie();
			players[endNum].tie();
			return "Tie!";
		}
	}

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
