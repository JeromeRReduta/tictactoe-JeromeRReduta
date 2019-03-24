import java.util.*;

/* GameDriver - Client program that allows a user to play the Game TictacToe.
 * Main is the only method found here. Other static helper methods can 
 * be used to organize the statements in main.
 * @author : STUDENT NAME
 * 
 */
public class GameDriver 
{
	// Makes 2 players, assigns them to playerList in random order, returns player list
	public static Player[] makePlayers(Scanner scan, Random rng) {
		Player[] players = new Player[2];

		int choice = rng.nextInt(2);

		System.out.print("Enter player 1 name: ");
		players[choice] = new Player(scan.nextLine());

		System.out.print("\n\nEnter player 2 name: ");;
		players[1-choice] = new Player(scan.nextLine());

		System.out.println(players[0].getName() + " goes 1st.\n" + players[1].getName() + " goes 2nd.");

		return players;
	}

	// Plays TicTacToe
	public static void playGame(Scanner scan, TicTacToe board, Player[] players) {

		// Loop keeps track of who won
		// 0 = No one yet | 1 = p1 wins | 2 = p2 wins | -1 = tie
		// Game loops until win or tie

		int loop = 0;
		int count = 0;

		System.out.println(board + "\n");
		
		while (loop == 0) {
		
			// Each player has one turn (i.e. two players don't have same turn #)
			System.out.println("TURN " + board.getTurnNum() + ":");
			System.out.println(players[count].getName() + "'s turn:");

			board.changeBoard(count+1);
			loop = board.checkForEnd(count + 1);
			System.out.println("\n\n\n\n\n" + board);

			// Count alternates btwn 0 and 1 - players alternates btwn 1st and 2nd player
			count = (count+1)%2;
		}

		// Prints end message based on who won, once game has ended
		System.out.println(board.endMessage(players, loop));
	}

	// Shows results, and asks if users want to play again
	public static int showResults(Scanner scan, Player[] players) {
		System.out.println(players[0] + "\n" + players[1]);

		System.out.println("Play again? [1] Yes [2] No");

		return scan.nextInt();


	}

	// Program
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		Random rng = new Random();

		Player[] players = makePlayers(scan, rng);

		// Loops until players choose not to play again
		int loop = 1;

		// Note: program makes fresh TicTacToe board every loop, but players stay the same
		while (loop == 1) {

			System.out.println("=======================");
			System.out.println("LET'S PLAY TIC TAC TOE!");
			System.out.println("=======================");

			TicTacToe board = new TicTacToe();

			playGame(scan, board, players);

			loop = showResults(scan, players);
		}
	}
}
