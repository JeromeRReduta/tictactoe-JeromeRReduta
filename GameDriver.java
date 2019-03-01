import java.util.*;

/* GameDriver - Client program that allows a user to play the Game TictacToe.
 * Main is the only method found here. Other static helper methods can 
 * be used to organize the statements in main.
 * @author : STUDENT NAME
 * 
 */
public class GameDriver 
{
	public static void main(String[] args)
	{

		TicTacToe board = new TicTacToe();
		Player player1, player2 = null;
		Scanner scan = new Scanner(System.in);

		System.out.println("=======================");
		System.out.println("LET'S PLAY TIC TAC TOE!");
		System.out.println("=======================");
		System.out.println(board);

		
		System.out.println("> Enter the name of Player1:");
		String name = scan.next();
		player1 = new Player(name);
		System.out.println("Welcome Player 1: "+player1.getName());
	}
}
